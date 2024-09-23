export PGDATA=$HOME/ewe49
export PGWAL=$HOME/svq55
export LANG=ru_RU.KOI8-R

echo $PGDATA
echo $PGWAL
echo $LANG

initdb -D $PGDATA --locale=$LANG --waldir=$PGWAL
