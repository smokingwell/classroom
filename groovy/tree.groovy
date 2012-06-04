def dir="/home/ryan/classroom"

def printDirTree(File f, int ntab){
 def PREFIX="--"
 def DIR_SEP="+"
  def sp=""
  for(i  in 1..ntab){
    sp+=PREFIX
  }

  f.eachDir(){
    println sp+DIR_SEP+it
    printDirTree(it, ntab+2)
  }
  f.eachFile{
    println sp+it
  }
}

printDirTree(new File(dir), 1)
