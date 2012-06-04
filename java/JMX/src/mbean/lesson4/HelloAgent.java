package mbean.lesson4;
import java.io.InputStream;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.modelmbean.ModelMBean;
import org.apache.commons.modeler.ManagedBean;
import org.apache.commons.modeler.Registry;
import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HelloAgent {
    public static void main(String[] args) throws Exception {
        //����xml�е���Ϣ����һ��Registry
        Registry registry = Registry.getRegistry(null, null);
        InputStream stream = HelloAgent.class.getResourceAsStream("Mbeans-descriptors.xml");
        registry.loadMetadata(stream);
        stream.close();
        
        //��Registry�õ�һ��MBeanServer
        MBeanServer server = registry.getMBeanServer();
        //�õ�Hello�������ļ��е���Ϣ�࣬��Ӧ��xml�ļ�<mbean>��ǩ��name���ԡ�
        ManagedBean managed = registry.findManagedBean("Hello");
        //����ObjectName
        ObjectName helloName = new ObjectName(managed.getDomain() + ":name=HelloWorld");
        //�õ�ModelMBean
        ModelMBean hello = managed.createMBean(new Hello());

        server.registerMBean(hello, helloName);
        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);

        adapter.start();
        System.out.println("start.....");
    }
} 

