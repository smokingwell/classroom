package mbean.lesson7;

import org.jboss.system.ServiceMBeanSupport;
public class HelloWorldService extends ServiceMBeanSupport implements HelloWorldServiceMBean {
    private String message;
    public String getMessage() {
        System.out.println("getMessage()=" + message);
        return message;
    }



    public void setMessage(String message) {
        System.out.println("setMessage(" + message + ")");
        this.message = message;
    }

    public void hello(){
      System.out.println("hello,"+message+"!");
    }
    
    public void go(){
      (new HelloWorldClient()).go();
    }
    
}
