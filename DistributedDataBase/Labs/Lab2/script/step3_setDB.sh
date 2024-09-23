pg_ctl -D /var/db/postgres2/ewe49 start

psql -U postgres2 -d postgres -p 9806 -c "ALTER USER postgres2 WITH PASSWORD '123456';"

mkdir /var/db/postgres2/gje71
mkdir /var/db/postgres2/xca33

psql -U postgres2 -d postgres -p 9806 -f $(pwd)/set_tablespace_db.sql

psql -U postgres2 -d postgres -p 9806 -f $(pwd)/set_role.sql

psql -U postgres2 -d fatbluefish -p 9806 -f $(pwd)/set_table.sql

psql -U postgres2 -d fatbluefish -p 9806 -c "select * from sales";
