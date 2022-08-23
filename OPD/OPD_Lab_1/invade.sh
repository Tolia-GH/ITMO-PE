#!bin/bash

for file in /home/s[0-9]*
do
	cd $file
	if [ -e lab0 ]
	then
		cd lab0
		pwd
		touch "space
invader"
		chmod 000 "space
invader"
	fi
done