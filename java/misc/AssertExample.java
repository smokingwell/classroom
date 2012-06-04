package j2se.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AssertExample{
	   public AssertExample(){}
	   public static void main(String args[]){
	      int x=10;
	      
		List c = null;
		Collections.sort(c,String.CASE_INSENSITIVE_ORDER);
	      System.out.println("Testing Assertion that x==100");
	      assert (x=99)!=100:"Our assertion failed!";
	      System.out.println(x);
	   }
	   
	}