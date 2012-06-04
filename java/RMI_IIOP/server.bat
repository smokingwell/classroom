set CP=%classpath%
set classpath=.;%classpath%
java -Djava.naming.factory.initial=com.sun.jndi.cosnaming.CNCtxFactory -Djava.naming.provider.url=iiop://localhost:900 -Djava.security.policy=policy HelloImpl
set classpath=%CP% 

