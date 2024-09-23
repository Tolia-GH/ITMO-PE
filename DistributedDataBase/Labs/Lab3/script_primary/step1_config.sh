pg_ctl -D /var/db/postgres2/ewe49 stop

rm /var/db/postgres2/ewe49/postgresql.conf

cp $(pwd)/postgresql.conf /var/db/postgres2/ewe49/

pg_ctl -D /var/db/postgres2/ewe49 start

psql -U postgres2 -d postgres -p 9806 -f $(pwd)/set_test_table.sql

psql -U postgres2 -d postgres -p 9806 -f $(pwd)/show_current_wal_file.sql

ls ~/svq55/archive_status

pg_basebackup -h localhost -p 9806 -D /var/db/postgres2/pg_backup -U postgres2 -Xs -R -P -T /var/db/postgres2/gje71=/var/db/postgres2/pg_backup/gje71 -T /var/db/postgres2/xca33=/var/db/postgres2/pg_backup/xca33

psql -U postgres2 -d postgres -p 9806 -f $(pwd)/show_current_wal_file.sql

ls ~/svq55/archive_status

rsync -avz /var/db/postgres2/pg_backup/ postgres2@pg120:/var/db/postgres2/pg_backup/

psql -U postgres2 -d postgres -p 9806 -f $(pwd)/show_current_wal_file.sql

psql -U postgres2 -d postgres -p 9806 -c "INSERT INTO test_table (data) SELECT md5(random()::text) FROM generate_series(1, 100);"

psql -U postgres2 -d postgres -p 9806 -c "SELECT * FROM test_table LIMIT 10;

psql -U postgres2 -d postgres -p 9806 -f $(pwd)/show_current_wal_file.sql

