package mytools.daomaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import mytools.util.FileTools;
import mytools.util.StringTools;

public abstract  class BaseDAOWorker implements IWorker {
	TableMeta tableMeta;
	private Translator translator;	
	String tableName = null;
	String translatedTableName = null;
	
	String getDAOPackageName(){
		return Option._dao_package_name;
	}
	String getVOPackageName(){
		return Option._vo_package_name;
	}
	//public static Option option=new Option();
	private static class Option{
		private static final String DAO_OPTION_FILEPATH = "/mytools/daomaker/dao.properties";
		private static String insert_pk_name;
		private static String insert_name;
		private static String updateByField_name;
		private static String update_name;
		private static String query_name;
		private static String queryExact_name;
		private static String delete_name;
		private static String _dao_package_name;
		private static String _vo_package_name;
		private static String _dao_exception_name;
		private final static Option o=new Option();
		
		public Option(){
			Properties p=FileTools.loadPropertiesFileByClassPath(this.getClass(),DAO_OPTION_FILEPATH);
			insert_pk_name=p.getProperty("insert_pk_name");
			insert_name=p.getProperty("insert_name");
			updateByField_name=p.getProperty("updateByFiel");
			update_name=p.getProperty("update_name");
			query_name=p.getProperty("query_name");
			queryExact_name=p.getProperty("queryExact_n");
			delete_name=p.getProperty("delete_name");
			_dao_package_name=p.getProperty("dao_package_name");
			_vo_package_name=p.getProperty("vo_package_name");
			_dao_exception_name=p.getProperty("dao_exception_name");
			
		}
	}
	public void init(Translator trans){
		this.translator=trans;
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
		fw = new FileWriter(output_directory+StringTools.replaceAll(Option._dao_package_name,".","\\")+ "\\" + translatedTableName+".java", false);
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
	     
	     if (Option.insert_pk_name != null && !Option.insert_pk_name.equals("")) {
	       fw.write(createInsertPKMethod(Option.insert_pk_name));
	       fw.write("\r");
	     }
	     if (Option.insert_name != null && !Option.insert_name.equals("")) {
	       fw.write(createInsertMethod(Option.insert_name));
	       fw.write("\r");
	     }

	     if (Option.update_name != null && !Option.update_name.equals("")) {
	       fw.write(createUpdateMethod(Option.update_name));
	       fw.write("\r");
	     }

	     if (Option.updateByField_name != null && !Option.updateByField_name.equals("")) {
	       fw.write(createUpdateByFieldMethod(Option.updateByField_name));
	       fw.write("\r");
	     }

	     if (Option.query_name != null && !Option.query_name.equals("")) {
	       fw.write(createQueryMethod(Option.query_name));
	       fw.write("\r");
	     }

	     if (Option.queryExact_name != null && !Option.queryExact_name.equals("")) {
	       fw.write(createQueryExactMethod(Option.queryExact_name));
	       fw.write("\r");
	     }

	     if (Option.delete_name != null && !Option.delete_name.equals("")) {
	       fw.write(createDeleteMethod(Option.delete_name));
	       fw.write("\r");
	     }	     
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
	   

		  public String createMemberVar() {
	    StringBuffer result = new StringBuffer();

	    result.append("  //��������Logger(log4j)\r");
	    result.append("  protected static Logger logger = Logger.getLogger(VO_" +
	    		translatedTableName + ".class.getName());\r");

	    return result.toString();
	  }
		  /**
		   * �����ļ�����,���ṹ,��Ȩ��Ϣ��
		   * @return String
		   */
		  public String createVersionHeader() {

		    StringBuffer result = new StringBuffer();

		    result.append("/**\r");
		    result.append(" * �ļ����ƣ�DAO_" + translatedTableName+ ".java" + "\r");
		    result.append(" * ���ṹ��" + Option._dao_package_name + "\r");
		    result.append(" *\r");
		    result.append(" * Copyright (c) 2005 zcdotcom Reserved.\r");
		    result.append(" */\r");

		    return result.toString();
		  }

		  /**
		   * �������Package, Import���������Ϣ
		   * @return String
		   */
		  public String createImportAndPackage() {

		    StringBuffer result = new StringBuffer();

		    result.append("package " + Option._dao_package_name + ".common;\r");
		    result.append("\r");
		    result.append("import java.sql.Statement;\r");
		    result.append("import java.sql.ResultSet;\r");
		    result.append("import java.util.ArrayList;\r");
		    result.append("import java.util.List;\r");
		    result.append("import org.apache.log4j.Logger;\r");

		    result.append("\r");
		    result.append("import " + Option._dao_package_name + ".DataAccessObject;\r" );
		    result.append("import " + Option._vo_package_name + ".common.*;\r" );
		    result.append("import " + Option._dao_package_name + "." + Option._dao_exception_name + ";\r" );

		    return result.toString();
		  }

		  /**
		   * ������ͷ
		   * @return String
		   */
		  public String createClassHeader() {

		    StringBuffer result = new StringBuffer();

		    result.append("/**\r");
		    result.append(" * ����������  ��" + tableMeta.getTableName()+ "�������ݿ������������.\r");
		    result.append(" * ����������: " + tableMeta.getTableName()+ "(" );
		    result.append(tableMeta.getTableComment()+ ")\r");
		    result.append(" *\r");
		    result.append(" * �� д �ˣ����ݱ��ļ��ۺϴ������\r");
		    result.append(" * ��д���ڣ�" + StringTools.getDateString(new Date()) + "\r");
		    result.append(" *\r");		    
		    result.append(" */\r");
		    result.append("\r");
		    result.append("public class DAO_" + translatedTableName+ " extends DataAccessObject\r" );
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
		    result.append("  public DAO_" + translatedTableName+ "() {\r");
		    result.append("  }\r");

		    return result.toString();
		  }

		  public String  createClassEnd() {

		    StringBuffer result = new StringBuffer();
		    result.append("}\r");
		    return result.toString();

		  }	
		  /**
		   * �����ֶε��������õ�JAVA����������
		   * @param database_type String
		   * @return String
		   */
		  	public abstract String getJavaType(String database_type) ;
		  	public abstract String createUpdateByFieldMethod(String updateByField_name);

			public abstract String createQueryMethod(String query_name) ;
			public abstract String createQueryExactMethod(String queryExact_name);

			public abstract String createDeleteMethod(String delete_name) ;

			public abstract String createUpdateMethod(String update_name) ;
			public abstract String createInsertMethod(String insert_name) ;

			public abstract String createInsertPKMethod(String insert_pk_name);
			
			public void create(String ddl_filepath, String output_directory,Translator translator){
				if(translator!=null)this.translator=translator;
				create(ddl_filepath,output_directory);
			}
}
