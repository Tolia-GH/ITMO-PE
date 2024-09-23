ALTER USER postgres2 WITH PASSWORD '123456';

CREATE TABLESPACE ts_gje71 LOCATION '/var/db/postgres2/gje71';

CREATE TABLESPACE ts_xca33 LOCATION '/var/db/postgres2/xca33';

CREATE DATABASE fatbluefish TEMPLATE template1;
