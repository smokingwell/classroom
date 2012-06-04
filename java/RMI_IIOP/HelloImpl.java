// HelloImpl.java
import javax.naming.*;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
//import java.rmi.server.UnicastRemoteObject;
import javax.rmi.PortableRemoteObject;

public class HelloImpl extends PortableRemoteObject
  implements Hello {
  public HelloImpl() throws RemoteException {
    super();
  }
  public String sayHello() {
    return "Hello World!";
  }

  public static void main(String args[]) {
  // Create and install a security manager
      if (System.getSecurityManager() == null) {
        System.setSecurityManager(new RMISecurityManager());
      }
      try {
          Hello obj = new HelloImpl();
          // Bind this object instance to the name "HelloServer"
          //***** old code for rmi
          // Naming.rebind("HelloServer", obj);
          //***** new code for rmi-iiop
          Context initialNamingContext = new InitialContext();
          initialNamingContext.rebind("HelloServer", obj);
          System.out.println("HelloServer bound in registry");
          } catch (Exception e) {
            System.out.println("HelloImpl err: " + e.getMessage());
            e.printStackTrace();
          }
      }
} 

