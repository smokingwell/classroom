//See the trap by: http://jbutton.iteye.com/blog/1569716
/** 
 * @Description:单例初始化探究 
 * @Author YHJ  create at 2011-6-4 下午08:31:19 
 * @FileName com.yhj.jvm.classloader.ClassLoaderTest.java 
 */  
class Singleton{  
     
    private static Singleton singleton=new Singleton();  
    private static int counter1;  
    private static int counter2 = 0;  
     
    public Singleton() {  
       counter1++;  
       counter2++;  
    }  
    public static int getCounter1() {  
       return counter1;  
    }  
    public static int getCounter2() {  
       return counter2;  
    }  
    /** 
     * @Description:实例化 
     * @return 
     * @author YHJ create at 2011-6-4 下午08:34:43 
     */  
    public static Singleton getInstance(){  
       return singleton;  
    }  
     
}  
/** 
 * @Description: 测试启动类 
 * @Author YHJ  create at 2011-6-4 下午08:35:13 
 * @FileName com.yhj.jvm.classloader.ClassLoaderTest.java 
 */  
public class SingletonStaticTrap {  
    /** 
     * @Description:启动类 
     * @param args 
     * @author YHJ create at 2011-6-4 下午08:30:12 
     */  
    @SuppressWarnings("static-access")  
    public static void main(String[] args) {  
       Singleton singleton=Singleton.getInstance();  
       System.out.println("counter1:"+singleton.getCounter1());  
       System.out.println("counter2:"+singleton.getCounter2());  
       System.out.println(singleton.getClass().getClassLoader());  
   
    }  
   
}  