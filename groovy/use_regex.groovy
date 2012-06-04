def x="/home/rzhang/a.txt"

def m= x=~/.*\/(.*)\.txt$/
if(m.find())
  println m.group(1)
