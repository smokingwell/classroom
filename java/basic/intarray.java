import java.io.*;
class intarray {
void resize (int[] a, int length_a, int[] b, int length_b) {
	a=b;
	System.out.println("then:"+ a[0]);
}
public static void main (String[] args) {
	int[] a= new int[5];
	int[] b= new int[10];
  a[0]=1;
  b[0]=2;

	intarray x = new intarray();
	System.out.println("first:"+a[0]);
	x.resize(a, 5, b, 10);
	System.out.println("then:"+ a[0]);
}
}
