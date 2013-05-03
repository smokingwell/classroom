list=`find . -name "*.sh"`
echo $list

for i in $list ;
do
  echo "this is:$i"
done
