import java.net.*;

public class TestTestStatic{
  public static void printme(TestObj t){
  System.out.println( "****************" );
  System.out.println( "static counter:" +t.st_count);
  System.out.println( "normal counter:" +t.count);
  System.out.println( "****************" );

  }

public static void main (String[] args)throws Exception {
	URL urls[] = new URL[]{new URL("file:///classroom/java/basic/a/b/c")};  
	/*
	URLClassLoader ucl1 = new URLClassLoader(urls);  
	URLClassLoader ucl2 = new URLClassLoader(urls);  
	Class<?> c1 = ucl1.loadClass("TestTestStatic");  
	Class<?> c2 = ucl2.loadClass("TestTestStatic");  
	System.out.println(ucl1 == ucl2);  
  */

	ClassLoader cl1= ClassLoader.getSystemClassLoader();  
  ClassLoader cl2= new URLClassLoader(urls);
  ClassLoader cl3= new  SimpleClassLoader("a/b/c");
  
  System.out.println("Two classloader:"+cl1 +","+ cl2+ "," +cl2.getParent() + "," + cl3 + ", " + cl3.getParent());

  //Class c1=cl1.loadClass("TestObj");
  Class c2=cl2.loadClass("TestObj");
  Class c3=cl3.loadClass("TestObj");
  System.out.println("Two class:"+","+c2 +"," + c3);
  //System.out.println("Two class equals:" + (c1==c2));
  /*
  TestObj t11=(TestObj)c1.newInstance();
  printme(t11);
  TestObj t12=(TestObj)c1.newInstance();
  printme(t12);
  TestObj t21=(TestObj)c2.newInstance();
  printme(t21);
  TestObj t22=(TestObj)c2.newInstance();
  printme(t22);
*/  
  TestObj t31=(TestObj)c3.newInstance();
  //System.out.println("do t11 and t21 have the same classload:" + t31.getClass().getClassLoader()+ "," + (t11.getClass().getClassLoader()==t31.getClass().getClassLoader()) );

  //System.out.println("Four class instance :" + t11 + "," + t12 + "," + t21 + "," + t22);
  
  
}
}
