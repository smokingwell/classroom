set CP=%classpath%
set classpath=.;%classpath%
java -Djava.naming.factory.initial=com.sun.jndi.cosnaming.CNCtxFactory -Djava.naming.provider.url=iiop://localhost:900 -Djava.security.policy=policy HelloClient %1
set classpath=%CP%

@rem policy
@rem grant {
@rem // Allow everything for now
@rem permission java.security.AllPermission;

