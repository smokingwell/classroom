umask 0000

echo "Do u create elem_addlist?"
echo "Do u use source command?"
echo "Do u use add the dbg brach as the last arguments?"
echo "Do u chmod 0755 all target files?"
echo "Do u have shell file?"

echo "sleep 4 seconds, if no interrupt, command will proceed!"
i="0"
while [ $i -lt 1 ] ; do
		sleep 1
		echo .
		i=$[$i + 1]
done


#check elem_addlist exists or not
if ! [ -a elem_addlist ] ; then
		echo "elem_addlist doesn't exist, create it first before run this command!"
	return
fi

if [ "$1" == '' ] ; then
		echo "please specify the debug branch name at the latest arguements"
		return
fi

for i in `cat elem_addlist`; do

#mv $i.keep $i ;
[ "$i" == 'elem_addlist' ] && continue;
[[ "$i" == *.sh ]] && continue;

echo  $i proceed 

clt mkelem -nc -nco $i;
clt mkbranch -nc $1 $i;
mv $i.keep $i;
done

