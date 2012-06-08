#!/bin/bash -v
#use -v to input commandline
#file

#test file
result= [ -e new ]
assertEquals 0 $?
#test string 
result= [ -z "abc" ]
assertEquals 0 $?
#test number
#echo $(( 1+1 ))
[ $# -eq 0 ] && (echo "arg counts is zero"; exit 1)

if [ $# -eq 0 ] ;then
		echo "usage"
		exit;
fi

if [ "$1" == "help" ] ;then
		echo "usage"
		exit 1
fi
if [ "$1" == "-help" ] ;then
		echo "usage"
		exit 1
fi

[[ "~e7104c" == f* ]] && echo "bingle"]]

if [ 1 -ne 0 ]
then
		echo "1 != 0"
	if [ 2 -ne 0 ]
	then
		echo " 2!=0"
	fi
fi
