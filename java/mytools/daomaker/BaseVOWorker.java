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
		assert tableName!=null&&tableName.length()>0:"������ȡʧ�ܣ�";
		
	    //����FileWriter���󣬲�ʵ����fw
		FileWriter fw = null;
		try {
		fw = new FileWriter(output_directory+StringTools.replaceAll(Option._vo_package_name,".","\\")+ "\\" + translatedTableName+".java", false);
		//���ַ���д���ļ�
		
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
	   * �����ļ�����,���ṹ,��Ȩ��Ϣ��
	   * @return String
	   */
	  public String createVersionHeader() {

	    StringBuffer result = new StringBuffer();

	    result.append("/**\r");
	    result.append(" * �ļ����ƣ�VO_" + tableName + ".java" + "\r");
	    result.append(" * ���ṹ��" + Option._vo_package_name+ "\r");
	    result.append(" *\r");
	    result.append(" * Copyright (c) 2004 Surekam corporation All Rights Reserved.\r");
	    result.append(" */\r");

	    return result.toString();
	  }

	  /**
	   * �������Package, Import���������Ϣ
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
	   * ������ͷ
	   * @return String
	   */
	  public String createClassHeader() {

	    StringBuffer result = new StringBuffer();

	    result.append("/**\r");
	    result.append(" * ����������  ��" + translatedTableName + "���ֶβ�����������.\r");
	    result.append(" * ����������: " + translatedTableName + "(" );
	    result.append(tableMeta.getTableComment() + ")\r");
	    result.append(" *\r");
	    result.append(" * �� д �ˣ����ݱ��ļ��ۺϴ������\r");
	    result.append(" * ��д���ڣ�" + StringTools.getDateString(new Date()) + "\r");
	    result.append(" *\r");	    
	    result.append(" */\r");
	    result.append("\r");
	    result.append("public class VO_" + tableName + " implements Serializable\r" );
	    result.append("{\r");

	    return result.toString();
	  }

	  /**
	   * ������Ĺ��캯��
	   * @return String
	   */
	  public String createConstructor() {

	    StringBuffer result = new StringBuffer();

	    result.append("  /**\r");
	    result.append("   * ���캯����ȱʡ���캯��\r");
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
	  // �ó���������ӿڵĶ���,��ҪΪ����VO�Ĳ�ͬ����
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
