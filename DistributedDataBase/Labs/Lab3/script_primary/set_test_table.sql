CREATE TABLE test_table (id serial PRIMARY KEY, data text);

SELECT * FROM test_table;

CREATE TABLE test_fkey_table (
    id serial PRIMARY KEY,
    data text
);

ALTER TABLE test_fkey_table ADD COLUMN test_table_id INT REFERENCES test_table(id);

SELECT * FROM test_fkey_table;
