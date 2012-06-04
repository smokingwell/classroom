/*
 * AbsDAOCreator.java
 *
 * ���ܣ���֯Creator�Ĳ�ͬ����������DAO,VO��.
 * ������AbsDAOCreator
 *
 *   ver    �����        ��˾     ������    �������
 * ��������������������������������������������������������������������
 *  V1.00  '04-04-21  �� (SURE)    ������    ����
 *
 * Copyright (c) 2004 Surekam corporation All Rights Reserved.
 */

package mytools.daomaker;

import java.util.Iterator;

import mytools.util.StringTools;

/**
 * Ĭ�ϵ�DA������������
 * 
 * 
 */

public class MysqVOCodeWorker extends BaseVOWorker { 

	  public String createMemberVar() {
	    StringBuffer result = new StringBuffer();

	    result.append("  //��������Logger(log4j)\r");
	    result.append("  protected static Logger logger = Logger.getLogger(VO_" +
	                  tableName + ".class.getName());\r");
	    result.append("\r" );

	    result.append("  //��������ֵ��ʼ��ֵ\r");
	    result.append("  protected static final long LONG_INIT_VALUE = Long.MAX_VALUE;\r");
	    result.append("\r" );

	    result.append("  //˫������ֵ��ʼ��ֵ\r");
	    result.append("  protected static final double DOUBLE_INIT_VALUE = \r");
	    result.append("    Double.parseDouble(Float.toString(Float.MAX_VALUE));\r");
	    result.append("\r" );

	    result.append("  //���ݿ��ֶζ�Ӧ���ÿ����Ա����\r" );

	    //ȡ�����ݱ�������ֶ�
	   /* VOTableInfo field_info = null;
	    String ch_field_name = null;
	    String ch_field_type = null;
	    String en_field_name = null;
	    String ch_field_comment = null;*/

	    Iterator _ch_field_items = tableMeta.getFieldList().iterator();
	    String memberVar = null;
	    while (_ch_field_items.hasNext()) {
	      //���ݱ�������ֶ���Ϣ
	      FieldMeta field_info = (FieldMeta)_ch_field_items.next();

	      //�����ֶ���
	      String ch_field_name = field_info.get_field_name();

	      //�����ֶ�����
	      String ch_field_type = field_info.get_field_type();

	      //Ӣ���ֶ���
	      String en_field_name = tableMeta.translate(ch_field_name);

	      //���������ݱ��Ӧ�ĳ�Ա����
	      memberVar = this.getMemberVariant(ch_field_type, en_field_name);
	      result.append("  " + memberVar + StringTools.getMargin(60 - memberVar.length()));
	      result.append("//" + ch_field_name + "\r");
	    }

	    return result.toString();
	  }

	  public String createSetMethods() {

	    StringBuffer result = new StringBuffer();

	    //ȡ�����ݱ�������ֶ�
	   /* VOTableInfo field_info = null;
	    String ch_field_name = null;
	    String ch_field_type = null;
	    String en_field_name = null;
	    String ch_field_comment = null;
	    String java_type = null;*/

	    Iterator _ch_field_items = tableMeta.getFieldList().iterator();
	    while (_ch_field_items.hasNext()) {
	      //���ݱ�������ֶ���Ϣ
	      FieldMeta field_info = (FieldMeta)_ch_field_items.next();

	      //�����ֶ���
	      String field_name = field_info.get_field_name();

	      //�����ֶ�����
	      String ch_field_type = field_info.get_field_type();

	      //Ӣ���ֶ���
	      String en_field_name = tableMeta.translate(field_name);
	      String java_type = getJavaType(ch_field_type);

	      result.append("  /**\r");
	      result.append("   * �������ݱ��ֶΡ�" + field_name + "����ֵ\r");
	      result.append("   */\r");
	      result.append("  public void set" + en_field_name + "(" + java_type + " " + en_field_name + ") {\r");
	      result.append("      " + getVariantName(ch_field_type, en_field_name) + " = " +
	                    en_field_name + ";\r");
	      result.append("  }\r");
	      result.append("\r");
	    }

	    return result.toString();
	  }

	  /**
	   * �����ֶε��������õ�JAVA����������
	   * @param mysql_type String
	   * @return String
	   */
	  public String getJavaType(String mysql_type) {

	    String java_type = "String";
	    mysql_type=mysql_type.toUpperCase();
	    if (mysql_type.startsWith("NUMBER")) {
	      if (mysql_type.indexOf(",") > 0) {
	        //�����ֶ�����ΪNUMBER(M,N),��Ӧjava����double
	        java_type = "double";
	      } else {
	        //�����ֶ�����ΪNUMBER(M),��Ӧjava����Ϊlong
	        java_type = "long";
	      }
	    } else if (mysql_type.startsWith("VARCHAR") ||
	               mysql_type.startsWith("CHAR")) {
	      //�����ֶ�����ΪVARCHAR, VARCHAR2��CHAR, ��Ӧjava����String
	        java_type = "String";
	    } else if (mysql_type.startsWith("DATE")) {
	      //�����ֶ�����ΪDATE��, ��Ӧjava����java.sql.Date
	        java_type = "String";
	    }

	    return java_type;
	  }

	public String createGetMethods() {

	    StringBuffer result = new StringBuffer();

	    //ȡ�����ݱ�������ֶ�
	    FieldMeta field_info = null;
	    String field_name = null;
	    String ch_field_type = null;
	    String en_field_name = null;
	    String java_type = null;

	    Iterator _ch_field_items = tableMeta.getFieldList().iterator();
	    while (_ch_field_items.hasNext()) {
	      //���ݱ�������ֶ���Ϣ
	      field_info = (FieldMeta)_ch_field_items.next();

	      //�����ֶ���
	      field_name = field_info.get_field_name();

	      //�����ֶ�����
	      ch_field_type = field_info.get_field_type();

	      //Ӣ���ֶ���
	      en_field_name = tableMeta.translate(field_name);
	      java_type = getJavaType(ch_field_type);

	      result.append("  /**\r");
	      result.append("   * ȡ�����ݱ��ֶΡ�" + field_name + "����ֵ\r");
	      result.append("   */\r");
	      result.append("  public " + java_type + " get" + en_field_name + "() {\r");
	      result.append("    return " + getVariantName(ch_field_type, en_field_name) + ";\r");
	      result.append("  }\r");
	      result.append("\r");
	    }

	    return result.toString();
	  }

	  public String createIsEmptyMethods() {

	    StringBuffer result = new StringBuffer();

	   /* //ȡ�����ݱ�������ֶ�
	    FieldMeta field_info = null;
	    String field_name = null;
	    String ch_field_type = null;
	    String en_field_name = null;
	    String ch_field_comment = null;
	    String java_type = null;*/

	    Iterator _ch_field_items = tableMeta.getFieldList().iterator();
	    while (_ch_field_items.hasNext()) {
	      //���ݱ�������ֶ���Ϣ
	      FieldMeta field_info = (FieldMeta)_ch_field_items.next();

	      //�����ֶ���
	      String field_name = field_info.get_field_name();

	      //�����ֶ�����
	      String ch_field_type = field_info.get_field_type();

	      //Ӣ���ֶ���
	      String en_field_name = tableMeta.translate(field_name);
	      result.append("  /**\r");
	      result.append("   * �ж����ݱ��ֶΡ�" + field_name + "���Ƿ�Ϊ��\r");
	      result.append("   */\r");
	      result.append("  public boolean isEmpty" + en_field_name + "() {\r");
	      result.append("    if (" + getEqualCondition(ch_field_type, en_field_name) + ") {\r");
	      result.append("      return true;\r");
	      result.append("    } else {\r");
	      result.append("      return false;\r");
	      result.append("    }\r");
	      result.append("  }\r");
	      result.append("\r");
	    }

	    return result.toString();
	  }

	  public String createGetInstance() {

	    StringBuffer result = new StringBuffer();

	    result.append("  /**\r");
	    result.append("    * ʵ������������̬����������ResultSet����ʵ��\r");
	    result.append("    */\r");
	    result.append("  public static VO_" + tableName + " getInstance(ResultSet rset)\r");
	    result.append("    throws Exception\r");
	    result.append("  {\r");
	    result.append("    try {\r");
	    result.append("      //����ʵ��\r");
	    result.append("      VO_JBOX_EQUIP valueObj = new VO_" + tableName + "();\r");

	    result.append("\r");
	    result.append("      //��������ֵ\r");

	   /* //ȡ�����ݱ�������ֶ�
	    FieldMeta field_info = null;
	    String field_name = null;
	    String ch_field_type = null;
	    String en_field_name = null;
	    String ch_field_comment = null;
	    String java_type = null;
*/
	    Iterator _ch_field_items = tableMeta.getFieldList().iterator();
	    while (_ch_field_items.hasNext()) {
	      //���ݱ�������ֶ���Ϣ
	      FieldMeta field_info = (FieldMeta)_ch_field_items.next();

	      //�����ֶ���
	      String field_name = field_info.get_field_name();

	      //�����ֶ�����
	      String field_type = field_info.get_field_type();

	      //Ӣ���ֶ���
	      String en_field_name = tableMeta.translate(field_name);
	      String java_type = getJavaType(field_type);
	      //java_type = StringTools.javaTypeUpper(java_type);

	      result.append("      if( rset.getString(\"" + field_name +
	                    "\") != null){\r");
	      result.append("        valueObj.set" + en_field_name +
	                    "(rset.get" + java_type + "(\"" + field_name +
	                    "\"));\r");
	      result.append("      }\r");
	    }

	    result.append("\r");
	    result.append("      //����ʵ��\r");
	    result.append("      return valueObj;\r");
	    result.append("    } catch(Exception e) {\r");
	    result.append("      //��������Ϣ����Log����\r");
	    result.append("      logger.error (\"<VO_" + tableName + ".getInstance> \"" +
	                  " + e);\r");
	    result.append("      //������\r");
	    result.append("      throw e;\r");
	    result.append("    }\r");
	    result.append("  }\r");

	    return result.toString();
	  }

	  private String getMemberVariant(String field_type, String field_name) {

	    String java_type = getJavaType(field_type);
	    String var_info = "";
	    if (java_type.equals("String")) {
	      var_info = getVariantName(field_type, field_name) + " = null;";
	    } else if (java_type.equals("long")) {
	      var_info = getVariantName(field_type, field_name) + " = LONG_INIT_VALUE;";
	    } else if (java_type.equals("double")) {
	      var_info = getVariantName(field_type, field_name) + " = DOUBLE_INIT_VALUE;";
	    } else if (java_type.equals("Date")) {
	      var_info = getVariantName(field_type, field_name) + " = null;";
	    } else {
	      var_info = getVariantName(field_type, field_name) + " = null;";
	    }
	    return "protected " + java_type + StringTools.getMargin(10 - java_type.length()) +
	        var_info;
	  }

	  private String getVariantName(String field_type, String field_name) {

	    String java_type =getJavaType(field_type);
	    String var_name = null;
	    if (java_type.equals("String")) {
	      var_name = "str" + field_name;
	    } else if (java_type.equals("long")) {
	      var_name = "lng" + field_name;
	    } else if (java_type.equals("double")) {
	      var_name = "dbl" + field_name;
	    } else if (java_type.equals("Date")) {
	      var_name = "dat" + field_name;
	    } else {
	      var_name = "obj" + field_name;
	    }

	    return var_name;
	  }

	  private String getEqualCondition(String field_type, String field_name) {

	    String java_type = getJavaType(field_type);
	    String var_name = this.getVariantName(field_type, field_name);
	    String equal_con = null;
	    if (java_type.equals("String")) {
	      equal_con = var_name + " == null";
	    } else if (java_type.equals("long")) {
	      equal_con = var_name + " == LONG_INIT_VALUE";
	    } else if (java_type.equals("double")) {
	      equal_con = var_name + " == DOUBLE_INIT_VALUE";
	    } else if (java_type.equals("Date")) {
	      equal_con = var_name + " == null";
	    } else {
	      equal_con = var_name + " == null";
	    }

	    return equal_con;
	  }
	  }
