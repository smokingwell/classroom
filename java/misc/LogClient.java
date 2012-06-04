package j2se.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


//Sep.30.2005 haixue start
public class LogClient {

public final static int ERROR = 0;

public final static int WARNING = 1;

public final static int INFO = 2;

public final static int DEBUG = 3;

static int logLevel = INFO;

static String[] logTypeString = { "ERROR", "WARNING", "INFO", "DEBUG" };

//private static LogClient instance_ = new
//LogClient("..\\sysout\\Logfile");
private static LogClient instance_ = new LogClient("..\\sysout\\client");

/**
* [219774] This new field is the path of the log file. Ex : String
* filename_ = "..\sysout\Logfile\OTACStarter.log"
*/
private  String filename_ = null;

/**
* Create a LogFile from the specified file path. If the related file does
* not exist, create it. This new constructor allows to have
* several log file at a time in a JVM.
*/
public LogClient(String filePath) {
String logFilePath = System.getProperty("otacstarter.logFilePath","sysout");
    System.setProperty("aremis.log.directory", logFilePath);
   System.out.println("LogClient() logFilePath:"+logFilePath);
   FileWriter writer;
  File tmpPath = new File(logFilePath);
        if(!tmpPath.exists())
        {
            tmpPath.mkdir();
        }
        filename_ = logFilePath + File.separator + "CampaignClient.log";
        //filename_="D:\\eclipse-SDK-3.1-win32\\eclipse\\workspace\\JAVALAB\\bin\\sysout\\CampaignClient.log";
        System.out.println( "create directory: " +
		tmpPath.getAbsolutePath());
//         File tmpLogFile = new File(filename_);
//         try
//         {
//              writer = new FileWriter(tmpLogFile);
//              writer.write("aaaaaaaaaaaaa");
//             writer.flush();
//             writer.close() ;
//         }
//         catch(Throwable e)
//         {
//             System.out.println(e);
//         }

}


public String getLogFilePath() {
return filename_;
}

/**
* Add the specified message, with the current date and time, in
* this LogFile.
*
* @see #toLogFile(java.lang.String)
*/
public void log(String message) {
StringBuffer sbMessage = new StringBuffer();
sbMessage.append(message);
sbMessage.append("\r\n");

writeWithDate_(sbMessage);
}

/**
*  Add the specified message (prefixed with 'EXCEPTION-') and the
* stack trace of the specified exception, with the current date and time,
* in this LogFile.
*/
public void log(String message, Exception e) {
log("EXCEPTION - " + message);
writeException_(e);
}

/**
*  Add the specified message, with the current date and time, in
* this LogFile.
*/
public void log(int logTypeNumber, String className, String method,
String message) {
System.out.println("log lever="+logLevel+"method="+method);
if (logTypeNumber > logLevel) {
System.out.println("log return");
return;
}

StringBuffer sbMessage = new StringBuffer();
sbMessage.append(logTypeString[logTypeNumber]);
sbMessage.append(" - ");
sbMessage.append(className);
sbMessage.append(".");
sbMessage.append(method);
sbMessage.append(" ");
sbMessage.append(message);
sbMessage.append("\r\n");
System.out.println("ready to write "+sbMessage);
writeWithDate_(sbMessage);
}

/**
* setFileName This method changes the name of the log file to open
*/
public static void setFileName(String name) {
instance_.setFilePath(name);
}

public void setFilePath(String name) {
filename_ = name;
}

public static void setLogLevel(int newLogLevel) {
logLevel = newLogLevel;
System.out.println("setLogLevel:"+logLevel);
}

/**
* toLogFile (int, String, String, String) This method writes a message to
* the log file The parameters passed to this method are: - log type
* (0:ERROR, 1:WARNING, 2:INFO, 3:DEBUG) - calling class name - calling
* method name - explicit message
*/
public static void toLogFile(int logTypeNumber, String className,
String method, String message) {
instance_.log(logTypeNumber, className, method, message);
}

/**
* toLogFile (String) This method writes a message to the log file The
* parameter passed to this method is: - explicit message
*/
public static void toLogFile(String message) {
instance_.log(message);
}

synchronized void writeException_(Exception e) {
try {
FileOutputStream os = new FileOutputStream(filename_, true);
PrintStream ps = new PrintStream(os);
e.printStackTrace(ps);
ps.flush();
ps.close();
os.close() ;
} catch (Exception ex) {
ex.printStackTrace();
}
}

/**
* [219761]
*/
synchronized void writeWithDate_(StringBuffer message) {
SimpleDateFormat simpleDateFormatDateTime = new SimpleDateFormat();
String FORMAT_DATE_TIME = "yyyy/MM/dd HH:mm:ss";
simpleDateFormatDateTime.applyPattern(FORMAT_DATE_TIME);

GregorianCalendar dateTime = new GregorianCalendar();
String dateTimeString = simpleDateFormatDateTime.format(dateTime
.getTime());
StringBuffer sbMessage = new StringBuffer();
sbMessage.append(dateTimeString);
sbMessage.append(" ");
sbMessage.append(message);
System.out.println("ready to write "+sbMessage);
try {
FileWriter writer1;
File tmpLogFile1 = new File(filename_);
System.out.println("filename_:"+tmpLogFile1.getAbsolutePath()) ;
             writer1 = new FileWriter(tmpLogFile1,true);
             writer1.write(sbMessage.toString());
            writer1.flush();
            writer1.close() ;


// File tmpPath2 = new File(filename_);
// System.out.println("filename_:"+tmpPath2.getAbsolutePath()) ;
//// java.io.BufferedOutputStream os = new
//java.io.BufferedOutputStream(new FileOutputStream(filename_, true));
//// PrintStream ps = new PrintStream(os);
//// ps.print(sbMessage.toString());
//// ps.flush();
//// System.out.println("flush");
//// ps.close();
//// os.close() ;
// FileWriter w=new FileWriter(tmpPath2,true);
// w.write(sbMessage.toString() );
// w.write("bbbbbbbbbbb");
// w.flush();
//            w.close() ;
}
catch (Exception e) {
e.printStackTrace();
System.out.println("can't write log");
}

}

/**
* This method write the specified message into the file defined with the
* 'setFileName' method. [219761] This method run but is no more used by
the
* class.
*/
static void writeWithDate(StringBuffer message) {
instance_.writeWithDate_(message);
}

/**
* Just for tests.
*/
public static void main(String[] args) {
//String s = null;
//LogClient log = new LogClient("Test2.log");
LogClient.toLogFile("begin");
//for(int i=0;i<100;i++){
Thread1 t1=new Thread1();
Thread t2=new Thread(new Thread2());
t1.start();

t2.start();
//}
/*try {
int i = s.length();
} catch (Exception e) {
e.printStackTrace();
log.log("LogFile : test exception traces", e);
}
log.log("mess1");
log.log("mess2");
log.log("mess3");
log.log(ERROR, "LogFile", "main", "mess4");
log.log("mess5");
*/
}

}
class Thread1 extends Thread{
public  void run(){
	try{
	String s="thread1...";
	LogClient.toLogFile(1,"classname","messname",s+"22");
	wait(5000);
	LogClient.toLogFile(1,"classname","messname",s+"2233");	
	}catch(Exception e){
		System.out.println(e);
		}
	}
}
class Thread2 implements Runnable{
public  void run(){
	String s="thread2...";
	LogClient.toLogFile(2,"classname2","messname2",s+"methor222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222");
	}

}
