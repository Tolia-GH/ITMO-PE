SELECT NOW(), pg_current_wal_lsn();

UPDATE test_fkey_table_table
SET test_table_id = FLOOR (RANDOM() * 100) + 1
WHERE test_table_id IS NOT NULL;

SELECT * FROM test_fkey_table;
SELECT * FROM test_table
ORDER BY id DESC
LIMIT 5; 
