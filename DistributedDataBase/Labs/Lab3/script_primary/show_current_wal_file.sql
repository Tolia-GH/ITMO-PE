DO $$
DECLARE
    current_lsn pg_lsn;
    wal_file_name text;
BEGIN
    -- ????? WAL LSN
    SELECT pg_current_wal_lsn() INTO current_lsn;

    -- ?? LSN ????? WAL ???
    SELECT pg_walfile_name(current_lsn) INTO wal_file_name;

    -- ????
    RAISE NOTICE 'Current WAL LSN: %', current_lsn;
    RAISE NOTICE 'Corresponding WAL file: %', wal_file_name;
END $$;

