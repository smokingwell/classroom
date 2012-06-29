#!/bin/bash 

if  [ 2 -lt 3 ] && [ 1 -lt 2 ] ; then
  echo "yes"
fi

if [ "$1" == 'collate_7.c' ] || [ "$1" == 'DBSize.c' ] ||  [ "$1" == 'xxx' ]; then
  echo "bingo"
else
  echo "poor"
fi


exit
#
i=2
echo $i
echo "$i"
echo '$i'

exit

#for 语法中也可以省略 [in list] 如果省略了，就用$@替换 即参数列表
for i ;do
  echo $i

done

