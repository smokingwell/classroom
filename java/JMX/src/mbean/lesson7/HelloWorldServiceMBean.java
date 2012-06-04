package mbean.lesson7;

import org.jboss.system.ServiceMBean;

public interface HelloWorldServiceMBean extends ServiceMBean {
    String getMessage();
    void setMessage(String message);
    void go();
    void hello();
}
