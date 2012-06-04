package mytools.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileTools {

	public static void cleanFile(final String type,final String path) {
		File directory=new File(path);
		String []file_toremove_list=directory.list(new FilenameFilter(){
	
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.endsWith(type))return true;
				return false;
			}
			
		});
		for(int i=0,j=file_toremove_list.length;i<j;i++){
			File file_torevmove=new File(path+file_toremove_list[i]);
			file_torevmove.delete();
		}
		
	}

	public static String[] getFileNames(final String endwith, String path) {
		File directory=new File(path);
		if(!directory.isDirectory())return null;
		String []result=directory.list(new FilenameFilter(){

			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.endsWith(endwith))return true;
				return false;
			}
			
		});
		return result;
	}
  public static void readFile(String filename){
    BufferedReader br= new BufferedReader( new FileReader (filename));
    while( (String str = br.readLine())!= null) {
      System.out.println(str);
    }
    br.close();
  }

	public static Properties loadPropertiesFileByPhysicalPath(String dao_option_filepath) {
		Properties properties = new Properties();
		  InputStream in = null;
			 try {
				//InputStream in = this.getClass().getResourceAsStream(OPTION_FILEPATH);
				in = new FileInputStream(dao_option_filepath);
				if (null == in) {
					throw new RuntimeException("Error: 找不到 参数配置文件 "+ dao_option_filepath);
				}
				properties.load(in);
			 }catch(IOException e){
			        e.printStackTrace(); 
			        throw new RuntimeException(e.toString());
			      } finally{
					if(in!=null)
						try {
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.print("关闭打开的配置文件"+dao_option_filepath+"时出错！");
						}
				}
		return properties;
		
	}
	public static Properties loadPropertiesFileByClassPath(Class theClass,String dao_option_filepath) {
		Properties properties = new Properties();		
		InputStream in = null;
		try {
			//InputStream in = this.getClass().getResourceAsStream(OPTION_FILEPATH);
			in = theClass.getResourceAsStream(dao_option_filepath);
			if (null == in) {
				throw new RuntimeException("Error: 找不到 参数配置文件 "+ dao_option_filepath);
			}
			properties.load(in);
		}catch(IOException e){
			e.printStackTrace(); 
			throw new RuntimeException(e.toString());
		} finally{
			if(in!=null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.print("关闭打开的配置文件"+dao_option_filepath+"时出错！");
				}
		}
		return properties;
		
	}
	
}
