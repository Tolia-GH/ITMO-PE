rm /var/db/postgres2/ewe49/postgresql.conf /var/db/postgres2/ewe49/pg_hba.conf

cp $(pwd)/postgresql.conf /var/db/postgres2/ewe49
cp $(pwd)/pg_hba.conf /var/db/postgres2/ewe49
