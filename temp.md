DROP procedure if exists Read_Tables_By_Name;  
CREATE OR REPLACE PROCEDURE Read_Tables_By_Name(rel TEXT) AS  

$$   
DECLARE   
    alloid INT[] := ARRAY(  
        SELECT C.oid   
        FROM pg_description D, pg_attribute A, pg_class C, pg_type T   
        WHERE C.relname = rel   
            AND A.attrelid = C.oid   
            AND A.atttypid = T.oid   
            AND A.attnum = D.objsubid   
            AND T.typname NOT LIKE '%id'   
            AND A.attnum > 0   
        ORDER BY C.oid  
    );  
      
    types TEXT[] := ARRAY(  
        SELECT T.typname   
        FROM pg_description D, pg_attribute A, pg_class C, pg_type T   
        WHERE C.relname = rel   
            AND A.attrelid = C.oid   
            AND A.atttypid = T.oid   
            AND A.attnum = D.objsubid   
            AND T.typname NOT LIKE '%id'   
            AND A.attnum > 0   
        ORDER BY C.oid  
    );  
  
    coloums_name TEXT[] := ARRAY(  
        SELECT A.attname   
        FROM pg_description D, pg_attribute A, pg_class C, pg_type T   
        WHERE C.relname = rel   
            AND A.attrelid = C.oid   
            AND A.atttypid = T.oid   
            AND A.attnum = D.objsubid   
            AND T.typname NOT LIKE '%id'   
            AND A.attnum > 0   
        ORDER BY C.oid  
    );  
      
    descriptions TEXT[] := ARRAY(  
        SELECT D.description   
        FROM pg_description D, pg_attribute A, pg_class C, pg_type T   
        WHERE C.relname = rel   
            AND A.attrelid = C.oid   
            AND A.atttypid = T.oid   
            AND A.attnum = D.objsubid   
            AND T.typname NOT LIKE '%id'   
            AND A.attnum > 0   
        ORDER BY C.oid  
    );  
      
    attnotnull BOOL[] := ARRAY(  
        SELECT A.attnotnull   
        FROM pg_description D, pg_attribute A, pg_class C, pg_type T   
        WHERE C.relname = rel   
            AND A.attrelid = C.oid   
            AND A.atttypid = T.oid   
            AND A.attnum = D.objsubid   
            AND T.typname NOT LIKE '%id'   
            AND A.attnum > 0   
        ORDER BY C.oid  
    );  
  
    result TEXT := FORMAT(E'Таблица:%s\noid:%s\n\n%5s%15s%40s\n%s', rel, alloid[1], 'No.', 'Имя столбца', 'Атрибуты', '---- ----------------- ------------------------------------------------------------');  
    i INT := 1;   
    num INT := 1;   
    o INT;   
    last INT := alloid[1];  
BEGIN   
    FOREACH o IN ARRAY alloid LOOP   
        IF o != last THEN   
            num := 1;   
            last := o;  
            result := result || FORMAT(E'\n\noid:%s\n%5s%15s%40s\n%s', o, 'No.', 'Имя столбца', 'Атрибуты', '---- ----------------- ------------------------------------------------------------');  
            result := result || E'\n';   
            result := E'\n%' || result;   
        END IF;  
  
        IF attnotnull[i] THEN   
            result := result || E'\n' || FORMAT('%-5s', num) || FORMAT('%15s', coloums_name[i]) || FORMAT('%15s', 'Type:') || FORMAT('%25s', types[i] || ' not null');  
        ELSIF NOT attnotnull[i] THEN   
            result := result || E'\n' || FORMAT('%-5s', num) || FORMAT('%15s', coloums_name[i]) || FORMAT('%15s', 'Type:') || FORMAT('%25s', types[i]);  
        END IF;  
  
        result := result || E'\n' || FORMAT('%15s', 'COMMEN:') || FORMAT('%-50s', descriptions[i]) || E'\n' || E'\n';  
        num := num + 1;   
        i := i + 1;   
    END LOOP;   
      
    RAISE INFO '%', result;   
END;   
$$ LANGUAGE plpgsql;  
  
CALL Read_Tables_By_Name('Н_УЧЕНИКИ');  
