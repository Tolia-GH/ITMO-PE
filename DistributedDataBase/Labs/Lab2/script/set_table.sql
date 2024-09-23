CREATE TABLE sales (
    id SERIAL,
    sale_date DATE,
    amount DECIMAL,
    PRIMARY KEY (id, sale_date)
) PARTITION BY RANGE (sale_date);

CREATE TABLE sales_2023 PARTITION OF sales
    FOR VALUES FROM ('2023-01-01') TO ('2023-12-31')
    TABLESPACE ts_gje71;

CREATE TABLE sales_2024 PARTITION OF sales
    FOR VALUES FROM ('2024-01-01') TO ('2024-12-31')
    TABLESPACE ts_xca33;

INSERT INTO sales (sale_date, amount) VALUES
    ('2023-02-15', 100.00),
    ('2023-06-20', 150.00),
    ('2024-03-10', 200.00);

