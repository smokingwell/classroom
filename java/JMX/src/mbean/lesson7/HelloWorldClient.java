package mbean.lesson7;

import org.jboss.mx.util.MBeanProxyExt;
import org.jboss.mx.util.ObjectNameFactory;
public class HelloWorldClient{
    public void go(){
        HelloWorldServiceMBean mbean = (HelloWorldServiceMBean) MBeanProxyExt.create(
                HelloWorldServiceMBean.class, 
                ObjectNameFactory.create("www.chengang.com.cn:service=HelloWorld"));

        String msg = mbean.getMessage();
        System.out.println("HellowWorldClient.go()=" + msg);
    }
    
} 
