println "hello world"
printFunctionName()
System.properties.each{println it}
println System.properties."user.home"

void printFunctionName(){
  println $it

}
