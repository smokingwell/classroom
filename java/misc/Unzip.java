import java.util.*;
import java.io.*;

public class Unzip{
public static void main(String args[]){
		if(args.length!=2){
			System.out.println("用法:Unzip zipfilename outputDirectory");
			return ;
		}
	unzip(args[0], args[1]);	
}

public static void unzip(String zipFileName,String outputDirectory) throws Exception{
try {
    org.apache.tools.zip.ZipFile zipFile = new org.apache.tools.zip.ZipFile(zipFileName);
    java.util.Enumeration e = zipFile.getEntries();
    org.apache.tools.zip.ZipEntry zipEntry = null;
    while (e.hasMoreElements()){
        zipEntry = (org.apache.tools.zip.ZipEntry)e.nextElement();
        System.out.println("unziping "+zipEntry.getName());
        if (zipEntry.isDirectory()){
            String name=zipEntry.getName();
            name=name.substring(0,name.length()-1);
            System.out.println("输出路径："+outputDirectory+File.separator+name);
            File f1=new File(outputDirectory+File.separator);
f1.mkdir();
            File f=new File(outputDirectory+File.separator+name);
            f.mkdir();
            System.out.println("创建目录："+outputDirectory+File.separator+name);
        }else{
            File f=new File(outputDirectory+File.separator+zipEntry.getName());
            f.createNewFile();
            InputStream in = zipFile.getInputStream(zipEntry);
            FileOutputStream out=new FileOutputStream(f);
            //--------解决了图片失真的情况
            int c;
            byte[] by=new byte[1024];
            while((c=in.read(by)) != -1){
                out.write(by,0,c);
            }
            out.close();
            in.close();
        }
    }
}
catch (Exception ex){
}
} 
}
