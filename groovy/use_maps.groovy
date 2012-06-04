def map1=[1:"abc", 2:"efg", 3:"hij", 4:"lmn"];
def map2=[1:"abc", 2:"Efg", 3:"KKK", 5:"jjj"];

println "map1:${map1}"
println "map2:${map2}"
println "after plus: ${map1+map2}"
println "map1-ma2: ${map1.collect{it.key}-map2.collect{it.key}}"
println "map2-map1 : ${map2.collect{it.key}-map1.collect{it.key}}"
println "difference: ${map1.findAll{ it.value != map2.getAt(it.key)}}"
