#!/bin/bash

for i in  `ls collate*.c ` ; do 
	if [ "$i" == 'shell.c' ] ; then
		echo "ignore $i"
	elif [ "$i" == 'DBSize.c' ] ; then
		echo "ignore $i"
#	elif [[ "$i" == collate*.c ]] ; then
#		perl -p -i -e 's/open_output\( argc, argv/open_output\( zLogFile/g' $i
#		echo "ignore $i"
	else
		echo "parse $i"

		perl -p -i -e 's/<stdio.h>/<stdio.h>\n#include "regtest_common.h"/g' $i
		perl -p -i -e 's/^int main\(\)/int main\(int argc, char **argv\)/g' $i
		perl -p -i -e 's/^{/{\n  FILE *fp_output = open_output( zLogFile );/g' $i
		perl -p -i -e 's/^{/{\n  if\( argc >= 2 \) zLogFile= argv[1];/g' $i
		perl -p -i -e 's/printf\(/fprintf\(fp_output, /g' $i
		perl -p -i -e 's/printf \(/fprintf\(fp_output, /g' $i
		perl -p -i -e 's/^  return 0;$/  close_output(fp_output);\n  return 0;/g' $i
	fi

done
