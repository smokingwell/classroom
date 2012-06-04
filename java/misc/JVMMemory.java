package j2se.util;

public class JVMMemory {
	public static void main(String args[]){
		Runtime rt=Runtime.getRuntime();
		long mem=rt.freeMemory();
		System.out.println(mem);
		System.gc();
		//System.gc();
		
		mem=rt.freeMemory();
		System.out.println(mem);
	}
}
