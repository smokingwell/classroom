RMI_IIOP简述:
RMI-IIOP出现以前，只有RMI和CORBA两种选择来进行分布式程序设计。RMI-IIOP综合了RMI 
和CORBA的优点，克服了他们的缺点，使得程序员能更方便的编写分布式程序设计，实现分布式计算。 
首先，RMI-IIOP综合了RMI的简单性和CORBA的多语言性（兼容性），其次RMI-IIOP克服了RMI只能 
用于Java的缺点和CORBA的复杂性（可以不用掌握IDL）

运行步骤:
1) 编译Hello.java, HelloImpl.java, HelloClient.java
2)生成stub，和Skeleton 运行rmic_iiop HelloImpl就会生成_Hello_stub.class, _HelloImpl_Tie.class
3)打开一个窗口:tnameserv
4)打开一个窗口:server.bat
5)打开一个窗口:client.bat localhost
