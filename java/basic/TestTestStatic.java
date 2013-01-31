import java.net.*;

public class TestTestStatic{
  public static int st_count=0;
  public int count=0;
  
  TestTestStatic(){
    st_count++;
    count++;
  }
  public void printme(){
  System.out.println( "****************" );
  System.out.println( "static counter:" +TestTestStatic.st_count);
  System.out.println( "normal counter:" +count);
  System.out.println( "****************" );

  }

public static void main (String[] args)throws Exception {
	URL urls[] = new URL[]{new URL("file:///classroom/java/basic")};  
	/*
	URLClassLoader ucl1 = new URLClassLoader(urls);  
	URLClassLoader ucl2 = new URLClassLoader(urls);  
	Class<?> c1 = ucl1.loadClass("TestTestStatic");  
	Class<?> c2 = ucl2.loadClass("TestTestStatic");  
	System.out.println(ucl1 == ucl2);  
  */

	ClassLoader cl1= ClassLoader.getSystemClassLoader();  
  ClassLoader cl2= new URLClassLoader(urls);
  System.out.println("Two classloader:"+cl1 +","+cl2);

  Class c1=cl1.loadClass("TestTestStatic");
  Class c2=cl2.loadClass("TestTestStatic");
  System.out.println("Two class:"+c1 +","+c2);

  TestTestStatic t11=(TestTestStatic)c1.newInstance();
  t11.printme();
  TestTestStatic t12=(TestTestStatic)c1.newInstance();
  t12.printme();

  TestTestStatic t21=(TestTestStatic)c2.newInstance();
  t21.printme();
  TestTestStatic t22=(TestTestStatic)c2.newInstance();
  t22.printme();

  System.out.println("Four class instance :" + t11 + "," + t12 + "," + t21 + "," + t22);
  
  
}
}
