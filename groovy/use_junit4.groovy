//class Use_Junit4Test extends TestCase{
import org.junit.*
import static org.junit.Assert.*

public class use_junit4 extends GroovyTestCase{ 
  @BeforeClass 
  static void doItOnce(){
    println "do it once"
  }

 @AfterClass 
  static void doItOnceButLast(){
    println "do it once but last"
  }

  @Before void doItEverytime(){
    println "do it everytime "
  }

  //@After 
def doItEverytimeAtEnd(){
    println "do it everytime but last"

  }
  @Test void test1(){
    println "test1"
    assertTrue(true)
    assertTrue(false)
  }

  @Test void test2(){
    println "test2"
    assertEquals( "abc", "abc")
  }

}
