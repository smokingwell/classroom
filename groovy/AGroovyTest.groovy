class AGroovyTest extends GroovyTestCase{
 void test1(){
    println "hello test1"
    assertTrue true
    assertTrue false
  }
 void test2() {
    println "hello test1"
    assertFalse false
  }
}
