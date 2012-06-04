/*
 * AbsDAOCreator.java
 *
 * 机能：组织Creator的不同方法来生成DAO,VO类.
 * 类名：AbsDAOCreator
 *
 *   ver    变更日        公司     担当者    变更内容
 * ──────────────────────────────────
 *  V1.00  '04-04-21  　 (SURE)    成晓勇    初版
 *
 * Copyright (c) 2004 Surekam corporation All Rights Reserved.
 */

package mytools.daomaker;

import java.util.Iterator;

import mytools.util.StringTools;

/**
 * 默认的DA代码生成器。
 * 
 * 
 */

public class MysqVOCodeWorker extends BaseVOWorker { 

	  public String createMemberVar() {
	    StringBuffer result = new StringBuffer();

	    result.append("  //定义该类的Logger(log4j)\r");
	    result.append("  protected static Logger logger = Logger.getLogger(VO_" +
	                  tableName + ".class.getName());\r");
	    result.append("\r" );

	    result.append("  //长整形数值初始化值\r");
	    result.append("  protected static final long LONG_INIT_VALUE = Long.MAX_VALUE;\r");
	    result.append("\r" );

	    result.append("  //双精度数值初始化值\r");
	    result.append("  protected static final double DOUBLE_INIT_VALUE = \r");
	    result.append("    Double.parseDouble(Float.toString(Float.MAX_VALUE));\r");
	    result.append("\r" );

	    result.append("  //数据库字段对应类的每个成员变量\r" );

	    //取得数据表的所有字段
	   /* VOTableInfo field_info = null;
	    String ch_field_name = null;
	    String ch_field_type = null;
	    String en_field_name = null;
	    String ch_field_comment = null;*/

	    Iterator _ch_field_items = tableMeta.getFieldList().iterator();
	    String memberVar = null;
	    while (_ch_field_items.hasNext()) {
	      //数据表的所有字段信息
	      FieldMeta field_info = (FieldMeta)_ch_field_items.next();

	      //中文字段名
	      String ch_field_name = field_info.get_field_name();

	      //中文字段类型
	      String ch_field_type = field_info.get_field_type();

	      //英文字段名
	      String en_field_name = tableMeta.translate(ch_field_name);

	      //定义与数据表对应的成员变量
	      memberVar = this.getMemberVariant(ch_field_type, en_field_name);
	      result.append("  " + memberVar + StringTools.getMargin(60 - memberVar.length()));
	      result.append("//" + ch_field_name + "\r");
	    }

	    return result.toString();
	  }

	  public String createSetMethods() {

	    StringBuffer result = new StringBuffer();

	    //取得数据表的所有字段
	   /* VOTableInfo field_info = null;
	    String ch_field_name = null;
	    String ch_field_type = null;
	    String en_field_name = null;
	    String ch_field_comment = null;
	    String java_type = null;*/

	    Iterator _ch_field_items = tableMeta.getFieldList().iterator();
	    while (_ch_field_items.hasNext()) {
	      //数据表的所有字段信息
	      FieldMeta field_info = (FieldMeta)_ch_field_items.next();

	      //中文字段名
	      String field_name = field_info.get_field_name();

	      //中文字段类型
	      String ch_field_type = field_info.get_field_type();

	      //英文字段名
	      String en_field_name = tableMeta.translate(field_name);
	      String java_type = getJavaType(ch_field_type);

	      result.append("  /**\r");
	      result.append("   * 设置数据表字段〖" + field_name + "〗的值\r");
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
	   * 根据字段的类型来得到JAVA的数据类型
	   * @param mysql_type String
	   * @return String
	   */
	  public String getJavaType(String mysql_type) {

	    String java_type = "String";
	    mysql_type=mysql_type.toUpperCase();
	    if (mysql_type.startsWith("NUMBER")) {
	      if (mysql_type.indexOf(",") > 0) {
	        //中文字段类型为NUMBER(M,N),对应java类型double
	        java_type = "double";
	      } else {
	        //中文字段类型为NUMBER(M),对应java类型为long
	        java_type = "long";
	      }
	    } else if (mysql_type.startsWith("VARCHAR") ||
	               mysql_type.startsWith("CHAR")) {
	      //中文字段类型为VARCHAR, VARCHAR2或CHAR, 对应java类型String
	        java_type = "String";
	    } else if (mysql_type.startsWith("DATE")) {
	      //中文字段类型为DATE型, 对应java类型java.sql.Date
	        java_type = "String";
	    }

	    return java_type;
	  }

	public String createGetMethods() {

	    StringBuffer result = new StringBuffer();

	    //取得数据表的所有字段
	    FieldMeta field_info = null;
	    String field_name = null;
	    String ch_field_type = null;
	    String en_field_name = null;
	    String java_type = null;

	    Iterator _ch_field_items = tableMeta.getFieldList().iterator();
	    while (_ch_field_items.hasNext()) {
	      //数据表的所有字段信息
	      field_info = (FieldMeta)_ch_field_items.next();

	      //中文字段名
	      field_name = field_info.get_field_name();

	      //中文字段类型
	      ch_field_type = field_info.get_field_type();

	      //英文字段名
	      en_field_name = tableMeta.translate(field_name);
	      java_type = getJavaType(ch_field_type);

	      result.append("  /**\r");
	      result.append("   * 取得数据表字段〖" + field_name + "〗的值\r");
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

	   /* //取得数据表的所有字段
	    FieldMeta field_info = null;
	    String field_name = null;
	    String ch_field_type = null;
	    String en_field_name = null;
	    String ch_field_comment = null;
	    String java_type = null;*/

	    Iterator _ch_field_items = tableMeta.getFieldList().iterator();
	    while (_ch_field_items.hasNext()) {
	      //数据表的所有字段信息
	      FieldMeta field_info = (FieldMeta)_ch_field_items.next();

	      //中文字段名
	      String field_name = field_info.get_field_name();

	      //中文字段类型
	      String ch_field_type = field_info.get_field_type();

	      //英文字段名
	      String en_field_name = tableMeta.translate(field_name);
	      result.append("  /**\r");
	      result.append("   * 判断数据表字段〖" + field_name + "〗是否为空\r");
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
	    result.append("    * 实例化函数：静态方法，根据ResultSet构造实例\r");
	    result.append("    */\r");
	    result.append("  public static VO_" + tableName + " getInstance(ResultSet rset)\r");
	    result.append("    throws Exception\r");
	    result.append("  {\r");
	    result.append("    try {\r");
	    result.append("      //创建实例\r");
	    result.append("      VO_JBOX_EQUIP valueObj = new VO_" + tableName + "();\r");

	    result.append("\r");
	    result.append("      //设置属性值\r");

	   /* //取得数据表的所有字段
	    FieldMeta field_info = null;
	    String field_name = null;
	    String ch_field_type = null;
	    String en_field_name = null;
	    String ch_field_comment = null;
	    String java_type = null;
*/
	    Iterator _ch_field_items = tableMeta.getFieldList().iterator();
	    while (_ch_field_items.hasNext()) {
	      //数据表的所有字段信息
	      FieldMeta field_info = (FieldMeta)_ch_field_items.next();

	      //中文字段名
	      String field_name = field_info.get_field_name();

	      //中文字段类型
	      String field_type = field_info.get_field_type();

	      //英文字段名
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
	    result.append("      //返回实例\r");
	    result.append("      return valueObj;\r");
	    result.append("    } catch(Exception e) {\r");
	    result.append("      //将错误信息进行Log处理\r");
	    result.append("      logger.error (\"<VO_" + tableName + ".getInstance> \"" +
	                  " + e);\r");
	    result.append("      //错误处理\r");
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
