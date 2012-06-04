package mbean.lesson5;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.modelmbean.RequiredModelMBean;
import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HelloAgent {
    public static void main(String[] args) throws Exception {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        ObjectName helloName = new ObjectName("chengang:name=HelloWorld");
        RequiredModelMBean hello = ModelMBeanUtils.createModelerMBean();
        server.registerMBean(hello, helloName);
        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);

        adapter.start();
        System.out.println("start.....");
    }
} 

