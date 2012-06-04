

public class int_test extends DoTest {

  public static void main(String[] args) throws Exception {
    assertTrue( 255 ==       0xFF );
    assertTrue( 255 == (char)0xFF );
    assertTrue( -1  == 0xFFFFFFFF ); // NOTICE!
    assertTrue( -1  != 0xFFFFFFFFL );

    assertTrue(   500654080  == 24 * 3600 * 1000 * 1000 ); // NOTICE!
    assertTrue( 86400000000L == 24 * 3600 * 1000 * 1000L );
    assertTrue(      500654  == 24 * 3600 * 1000 * 1000 / 1000L ); // NOTICE!
    assertTrue(    86400000  == 24 * 3600 * 1000 * 1000L / 1000 );
	
	//assertTrue(1*10==12);
	//assertEquals(10,12);
	
    assertTrue( -7616 == (short)123456 );

    assertTrue( -1 == -3 % 2 );

    java_specific_test();
  }

  public static void java_specific_test() throws Exception {
    assertTrue( -1  == (byte)0xFF ); // NOTICE!

    assertTrue( 65535 == (int)(char)(byte)-1 ); // NOTICE!
  }
}
