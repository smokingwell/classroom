package mytools.daomaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import mytools.util.FileTools;
import mytools.util.StringTools;

public abstract class BaseVOWorker implements IWorker {
	TableMeta tableMeta;
	private Translator translator;	
	String tableName = null;
	String translatedTableName = null;
	private static class Option{
		private static final String VO_OPTION_FILEPATH = "/mytools/daomaker/vo.properties";		
		private static String _vo_package_name;
		private final static Option o=new Option();
		
		public Option(){
			Properties p=FileTools.loadPropertiesFileByClassPath(this.getClass(),VO_OPTION_FILEPATH);			
			_vo_package_name=p.getProperty("vo_package_name");
			
		}
	}
	public void create(String ddl_filepath, String output_directory) {
		// TODO Auto-generated method stub
		tableMeta=new TableMeta(ddl_filepath,translator);		
		tableName=tableMeta.getTableName();
		translatedTableName=tableMeta.translate(tableMeta.getTableName());
		assert tableName!=null&&tableName.length()>0:"表名获取失败！";
		
	    //建立FileWriter对象，并实例化fw
		FileWriter fw = null;
		try {
		fw = new FileWriter(output_directory+StringTools.replaceAll(Option._vo_package_name,".","\\")+ "\\" + translatedTableName+".java", false);
		//将字符串写入文件
		
	      fw.write(createVersionHeader());
	      fw.write("\r");
	      fw.write(createImportAndPackage());
	      fw.write("\r");
	      fw.write(createClassHeader());
	      fw.write("\r");
	      fw.write(createMemberVar());
	      fw.write("\r");
	      fw.write(createConstructor());
	      fw.write("\r");
	      fw.write(createGetInstance());
	      fw.write("\r");
	      fw.write(createSetMethods());
	      fw.write("\r");
	      fw.write(createGetMethods());
	      fw.write("\r");
	      fw.write(createIsEmptyMethods());

	      fw.write(createClassEnd());
	      fw.write("\r");

	      fw.close();
	    
	     } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally{
			if(fw!=null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	   }
	   

	
	/*******/
	  /**
	   * 创建文件名称,包结构,版权信息等
	   * @return String
	   */
	  public String createVersionHeader() {

	    StringBuffer result = new StringBuffer();

	    result.append("/**\r");
	    result.append(" * 文件名称：VO_" + tableName + ".java" + "\r");
	    result.append(" * 包结构：" + Option._vo_package_name+ "\r");
	    result.append(" *\r");
	    result.append(" * Copyright (c) 2004 Surekam corporation All Rights Reserved.\r");
	    result.append(" */\r");

	    return result.toString();
	  }

	  /**
	   * 创建类的Package, Import等类基本信息
	   * @return String
	   */
	  public String createImportAndPackage() {

	    StringBuffer result = new StringBuffer();

	    result.append("package " + Option._vo_package_name + ".common;\r");
	    result.append("\r");
	    result.append("import java.io.Serializable;\r");
	    result.append("import java.sql.ResultSet;\r");
	    result.append("import org.apache.log4j.Logger;\r");

	    return result.toString();
	  }

	  /**
	   * 创建类头
	   * @return String
	   */
	  public String createClassHeader() {

	    StringBuffer result = new StringBuffer();

	    result.append("/**\r");
	    result.append(" * 程序描述：  表〖" + translatedTableName + "〗字段操作方法定义.\r");
	    result.append(" * 操作表名称: " + translatedTableName + "(" );
	    result.append(tableMeta.getTableComment() + ")\r");
	    result.append(" *\r");
	    result.append(" * 编 写 人：数据表文件综合处理程序\r");
	    result.append(" * 编写日期：" + StringTools.getDateString(new Date()) + "\r");
	    result.append(" *\r");	    
	    result.append(" */\r");
	    result.append("\r");
	    result.append("public class VO_" + tableName + " implements Serializable\r" );
	    result.append("{\r");

	    return result.toString();
	  }

	  /**
	   * 创建类的构造函数
	   * @return String
	   */
	  public String createConstructor() {

	    StringBuffer result = new StringBuffer();

	    result.append("  /**\r");
	    result.append("   * 构造函数：缺省构造函数\r");
	    result.append("   */\r");
	    result.append("  public VO_" + tableName + "() {\r");
	    result.append("  }\r");

	    return result.toString();
	  }

	  public String  createClassEnd() {

	    StringBuffer result = new StringBuffer();
	    result.append("}\r");
	    return result.toString();

	  }

	  //********************************************************************
	  // 该抽象类基本接口的定义,主要为创建VO的不同方法
	  //********************************************************************

	  public abstract String createMemberVar();

	  public abstract String createGetInstance();

	  public abstract String createSetMethods();

	  public abstract String createGetMethods();

	  public abstract String createIsEmptyMethods();
	  
	  public void create(String ddl_filepath, String output_directory,Translator translator){
			if(translator!=null)this.translator=translator;
			create(ddl_filepath,output_directory);
		}
	

}
