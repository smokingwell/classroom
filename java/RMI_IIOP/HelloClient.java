import java.rmi.RMISecurityManager;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import javax.rmi.PortableRemoteObject;
import javax.naming.*;
public class HelloClient {
    public static void main(String args[]) throws Exception{

        System.setSecurityManager(new RMISecurityManager());

        Context initialNamingContext = new InitialContext();
        Hello RemoteObj = (Hello) PortableRemoteObject.narrow(
          initialNamingContext.lookup("iiop://"+ args[0] +"/HelloServer"),
          Hello.class
        );

        System.out.println(RemoteObj.sayHello());
    }
} 

