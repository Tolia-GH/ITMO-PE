CREATE OR REPLACE PROCEDURE get_pf_constraint_info(schema TEXT)
LANGUAGE plpgsql
AS
$$
    DECLARE
        constraint_record RECORD;
    BEGIN
        RAISE INFO '% % % % % %',
            format('%-40s', 'Имя ограничения'),
            format('%-3s', 'Тип'),
            format('%-20s', 'Имя таблицы'),
            format('%-30s', 'Имя столбцов'),
            format('%-20s', 'Имя внешней таблицы'),
            format('%-30s', 'Имя внешних столбцов');
        RAISE INFO '% % % % % %',
            repeat('-', 40),
            repeat('-', 3),
            repeat('-', 20),
            repeat('-', 30),
            repeat('-', 20),
            repeat('-', 30);
        FOR constraint_record IN
            SELECT 
                conname AS constraint_name,
                contype AS constraint_type,
                conrelid::regclass::text AS table_name,
                array_agg(DISTINCT a.attname) AS column_names,
                f.relname AS foreign_table,
                array_agg(DISTINCT af.attname) AS foreign_column_names
            FROM
                pg_constraint c
                JOIN pg_namespace namespace ON c.connamespace = namespace.oid
                JOIN pg_class t ON c.conrelid = t.oid
                JOIN pg_attribute a ON a.attrelid = t.oid AND a.attnum = ANY(c.conkey)
                LEFT JOIN pg_class f ON c.confrelid = f.oid
                LEFT JOIN pg_attribute af ON af.attrelid = f.oid AND af.attnum = ANY(c.confkey)
            WHERE namespace.nspname = schema AND contype IN ('p', 'f')
            GROUP BY conname, contype, table_name, foreign_table
        LOOP
            IF constraint_record.constraint_type = 'p' THEN
                RAISE INFO '% % % %',
                    format('%-40s', constraint_record.constraint_name),
                    format('%-3s', 'P'),
                    format('%-20s', constraint_record.table_name),
                    format('%-30s', array_to_string(constraint_record.column_names, ', '));
            ELSIF constraint_record.constraint_type = 'f' THEN
                RAISE INFO '% % % % % %',
                    format('%-40s', constraint_record.constraint_name),
                    format('%-3s', 'R'),
                    format('%-20s', constraint_record.table_name),
                    format('%-30s', array_to_string(constraint_record.column_names, ', ')),
                    format('%-20s', constraint_record.foreign_table),
                    format('%-30s', array_to_string(constraint_record.foreign_column_names, ', '));
            END IF;
        END LOOP;
    END
$$;
