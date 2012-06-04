#!/bin/bash

if [[ "$1" == --h* ]] ; then
		echo "usage: howmanydiff [your branch name]"
		exit
fi
#exit
if [ "$1" != "" ] ; then
		clt find . -branch "brtype($1)" -print > file_list
fi

if [ ! -e file_list ] ; then
		echo "file_list doesn't exist, use find . -branch '' -print to generate it! "
		exit
fi
rm -f /tmp/diff.txt
rm -f /tmp/review.txt
changed=0;
deleted=0;

for i in `cat file_list` ; do
	diff $i/0 $i/LATEST >>/tmp/diff.txt
	diff -u $i/0 $i/LATEST  >>/tmp/review.txt
done

if [ -e /tmp/diff.txt ] ; then
changed=`sed -n '/>.*/p' /tmp/diff.txt |wc -l`
deleted=`sed -n '/^[0-9]*d/p' /tmp/diff.txt|wc -l`
fi

echo changed line :$changed line
echo delete occurs :$deleted
echo total estimate:$[$changed+$deleted] line
echo detail information stored in /tmp/review.txt
