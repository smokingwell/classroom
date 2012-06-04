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
import java.util.List;

import mytools.util.StringTools;

/**
 * 默认的DA代码生成器。
 * 
 * 
 */

public class MysqlDAOCodeWorker extends BaseDAOWorker {
	/**
	 * 插入时,如果不是最后一个字段,则返回 + "," 反之,则返回 + )
	 * 
	 * @param field_items
	 *            Iterator
	 * @return String
	 */
	private String addCommaInsert(Iterator field_items) {
		if (field_items.hasNext()) {
			return " + \", \"";
		} else {
			return " + \")\"";
		}
	}

	/**
	 * 更新,如果还没有到最后一个字段,则返回 + "," 反之,则返回 +
	 * 
	 * @param field_items
	 *            Iterator
	 * @return String
	 */
	private String addCommaUpdate(Iterator field_items) {
		if (field_items.hasNext()) {
			return " + \", \"";
		} else {
			return " + \"\"";
		}
	}

	/**
	 * 更新(字段),返回 + ","
	 * 
	 * @param field_items
	 *            Iterator
	 * @return String
	 */
	private String addCommaUpdateByField(Iterator field_items) {
		return " + \", \"";
	}

	/**
	 * 如果字段的类型是String型,则返回 + "%'" 反之, 则返回空
	 * 
	 * @param ch_field_type
	 *            String
	 * @return String
	 */
	private String addLikeEnd(String ch_field_type) {

		String java_type = getJavaType(ch_field_type);
		if (java_type.equals("String")) {
			if (ch_field_type.toUpperCase().equals("DATE")) {
				return " + \"', 'yyyy-MM-dd HH24:MI:SS')\"";
			} else {
				return " + \"%'\"";
			}
		}
		return "";
	}

	/**
	 * 如果字段的类型是String型,则返回 "LIKE '%" + 反之, 则返回空
	 * 
	 * @param ch_field_type
	 *            String
	 * @return String
	 */
	private String addLikeStart(String ch_field_type) {

		String java_type = getJavaType(ch_field_type);
		if (java_type.equals("String")) {
			if (ch_field_type.toUpperCase().equals("DATE")) {
				return "\"TO_DATE('\" + ";
			} else {
				return "\"'%\" + ";
			}
		}
		return "";
	}

	/**
	 * 如果字段的类型是String型,则返回 + "'" 反之, 则返回空
	 * 
	 * @param ch_field_type
	 *            String
	 * @return String
	 */
	private String addSingleQuotesEnd(String ch_field_type) {

		String java_type = getJavaType(ch_field_type);
		if (java_type.equals("String")) {
			if (ch_field_type.toUpperCase().equals("DATE")) {
				return " + \"', 'yyyy-MM-dd HH24:MI:SS')\"";
			} else {
				return " + \"'\"";
			}
		}
		return "";
	}

	/**
	 * 如果字段的类型是String型,则返回 "'" + 反之, 则返回空
	 * 
	 * @param ch_field_type
	 *            String
	 * @return String
	 */
	private String addSingleQuotesStart(String ch_field_type) {

		String java_type = getJavaType(ch_field_type);
		if (java_type.equals("String")) {
			if (ch_field_type.toUpperCase().equals("DATE")) {
				return "\"TO_DATE('\" + ";
			} else {
				return "\"'\" + ";
			}
		}
		return "";
	}

	/**
	 * 生成压要插入到DAO中的Delete方法
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createDeleteMethod(String methodName) {
		StringBuffer result = new StringBuffer();
		String tableName = tableMeta.getTableName();
		String translatedTableName = tableMeta.translate(tableMeta
				.getTableName());

		result.append("  /**\r");
		result.append("   * 根据参数VO[]删除表〖" + tableName + "〗中的相应记录\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ "[] delete操作所需的参数\r");
		result.append("   * @return int 数据库中成功delete的条数\r");
		result.append("   * @Exception 当数据库操作发生异常时\r");
		result.append("   */\r");
		
		result.append(outputMethodBegin(methodName));

		result.append("      for (int i = 0; i < valueObj.length; i++) {\r");
		result.append("        //SQL语句字符串缓冲变量\r");
		result.append("        StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("        //初始化SQL语句\r");
		result.append("        sql.append(\"DELETE \");\r");
		result.append("        sql.append(\"" + tableName + " WHERE \");\r");

		// 取得数据表的所有字段
		Iterator _ch_field_items = tableMeta.getFieldList().iterator();
		while (_ch_field_items.hasNext()) {
			// 数据表的所有字段信息
			FieldMeta field_info = (FieldMeta) _ch_field_items.next();

			String field_name = field_info.get_field_name();
			String translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_name);

			// 中文字段类型
			String ch_field_type = field_info.get_field_type();

			result.append("\r");
			result.append("        //将字段『" + field_info.get_field_name()
					+ "』的信息加入SQL文\r");
			result.append("        if (!valueObj[i].isEmpty"
					+ translated_field_name + "()) {\r");
			result.append("          sql.append(\""
					+ field_info.get_field_name() + "=\");\r");
			result.append("          sql.append("
					+ addSingleQuotesStart(ch_field_type) + "valueObj[i].get"
					+ translated_field_name + "()"
					+ addSingleQuotesEnd(ch_field_type) + " + \" AND \"); \r");
			result.append("        }\r");
		}

		result.append("\r");

		result.append("        //去掉SQL文的最后一个'AND'\r");
		result.append("        String sqlExec = sql.toString();\r");
		result.append("        int index = sqlExec.lastIndexOf(\"AND\");\r");
		result
				.append("        sqlExec = sqlExec.substring(0, index).trim();\r");

		result.append(outputLogSql(methodName));
		result.append("        //将更新的记录条数进行累加\r");
		result.append("        delete_count += stmt.executeUpdate(sqlExec);\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //返回插入成功插入数据库的记录条数\r");
		result.append("      return delete_count;\r");

		result.append(outputMethodEnd(methodName));

		return result.toString();
	}

	/**
	 * 生成要插入到DAO中的Insert方法
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createInsertMethod(String methodName) {

		StringBuffer result = new StringBuffer();

		result.append("  /**\r");
		result.append("   * 将参数VO[]中的数据插入到表〖" + tableName + "〗中\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ "[] insert操作所需的参数\r");
		result.append("   * @return int insert到数据库中的条数\r");
		result.append("   * @Exception 当数据库操作发生异常时\r");
		result.append("   */\r");

		result.append(outputMethodBegin(methodName));
		result.append("      for (int i = 0; i < valueObj.length; i++) {\r");

		result.append("        //SQL语句字符串缓冲变量\r");
		result.append("        StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("        //初始化SQL语句\r");
		result.append("        sql.append(\"INSERT INTO \");\r");
		result.append("        sql.append(\"" + tableName + "(\");\r");

		// 取得数据表的所有字段

		Iterator _ch_field_items = tableMeta.getFieldList().iterator();
		boolean firstTurn = true;
		while (_ch_field_items.hasNext()) {
			// 数据表的所有字段信息
			FieldMeta field_info = (FieldMeta) _ch_field_items.next();

			// 英文字段名
			String translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_info.get_field_name());

			// 中文字段类型
			String ch_field_type = field_info.get_field_type();
			boolean field_not_null = field_info.is_field_not_null();

			// 创建要插入的字段名以及注释
			if (_ch_field_items.hasNext()) {
				result.append("        sql.append(\""
						+ field_info.get_field_name()
						+ ", \");"
						+ StringTools.getMargin(16 - field_info
								.get_field_name().getBytes().length) + "//"
						+ field_info.get_field_name() + "\r");
			} else {
				result.append("        sql.append(\""
						+ field_info.get_field_name()
						+ ") \");"
						+ StringTools.getMargin(16 - 1 - field_info
								.get_field_name().getBytes().length) + "//"
						+ field_info.get_field_name() + "\r");
			}

			if (firstTurn) {
				result.append("      sql.append(\"VALUES(\");\r");
				result.append("\r");
				firstTurn = false;
			}

			ch_field_type = ch_field_type.toUpperCase();

			result.append("        //将字段『" + field_info.get_field_name()
					+ "』的信息加入SQL文\r");
			if (field_not_null) {
				result.append("        sql.append(");

				/*
				 * if (_sequence_table_name != null &&
				 * _sequence_table_name.length() > 0 &&
				 * _ch_field_key.equals(field_info.get_field_name())) {
				 * result.append("\"" + _sequence_table_name + ".nextval\"" +
				 * addCommaInsert(_ch_field_items) + "); \r"); } else {
				 * result.append(addSingleQuotesStart(ch_field_type) +
				 * "valueObj[i].get" + en_field_name + "()" +
				 * addSingleQuotesEnd(ch_field_type) +
				 * addCommaInsert(_ch_field_items) + "); \r"); }
				 */
			} else {

				result.append("        if (!valueObj[i].isEmpty"
						+ translated_field_name + "()) {\r");
				result.append("          sql.append("
						+ addSingleQuotesStart(ch_field_type)
						+ "valueObj[i].get" + translated_field_name + "()"
						+ addSingleQuotesEnd(ch_field_type)
						+ addCommaInsert(_ch_field_items) + "); \r");
				result.append("        } else {\r");
				result.append("          sql.append(\""
						+ getNullAndDefault(field_info) + "\""
						+ addCommaInsert(_ch_field_items) + "); \r");
				result.append("        }\r");
			}
			result.append("\r");
		}

		result.append(outputLogSql(methodName));

		result.append("      //执行操作将记录插入数据库\r");
		result.append("      stmt.executeUpdate(sql.toString());\r");
		result.append("\r");
		result.append("      //将插入记录的主键返回\r");
		result.append("      return lng_key;\r");

		result.append(outputMethodEnd(methodName));
		return result.toString();
	}

	/**
	 * 生成要插入到DAO中的Insert_PK方法
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createInsertPKMethod(String methodName) {

		StringBuffer result = new StringBuffer();

		result.append("  /**\r");
		result.append("   * 将参数VO中的数据插入到表〖" + tableMeta.getTableName()
				+ "〗中,\r");
		result.append("   * 并返回所插入记录的主键\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ " insert操作所需的参数\r");
		result.append("   * @return long 所insert记录的主键\r");
		result.append("   * @Exception 当数据库操作发生异常时\r");
		result.append("   */\r");

		result.append(outputMethodBegin(methodName));
		/*
		 * result.append(" //SQL语句字符串缓冲变量\r"); result.append(" StringBuffer
		 * sql_seq = new StringBuffer();\r");
		 */
		// if (_sequence_table_name != null &&
		// _sequence_table_name.length() > 0) {
		/*
		 * result.append( " sql_seq.append(\"SELECT " + _sequence_table_name +
		 * ".nextval as max FROM DUAL\");\r");
		 */
		// } else {
		// result.append(
		// " sql_seq.append(\"SELECT MAX(" + _ch_field_key +
		// ") as max FROM DUAL\");\r");
		// }
		result.append("\r");
		/*
		 * result.append(" //将调试信息进行Log处理\r"); result.append( " logger.info(\"<DAO_"
		 * +translatedTableName + "." + methodName + "> \" +
		 * sql_seq.toString());\r"); result.append("\r"); result.append("
		 * //执行数据库操作\r"); result.append( " ResultSet rset =
		 * stmt.executeQuery(sql_seq.toString());\r"); result.append(" long
		 * lng_key = -1;\r"); result.append(" if(rset.next()){\r");
		 * result.append(" lng_key = rset.getLong(\"max\");\r"); result.append("
		 * //将调试信息进行Log处理\r"); result.append(" logger.info(\"<DAO_" +
		 * translatedTableName+ "." + methodName + "> 取得主键:\" + lng_key);\r");
		 * result.append(" }\r"); result.append("\r");
		 * 
		 */
		result.append("      //SQL语句字符串缓冲变量\r");
		result.append("      StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("      //初始化SQL语句\r");
		result.append("      sql.append(\"INSERT INTO \");\r");
		result.append("      sql.append(\"" + tableMeta.getTableName()
				+ "(\");\r");

		// 取得数据表的所有字段

		Iterator field_items = tableMeta.getFieldList().iterator();
		boolean firstTurn = true;
		while (field_items.hasNext()) {
			// 数据表的所有字段信息
			FieldMeta field_info = (FieldMeta) field_items.next();

			// 中文字段名
			String field_name = field_info.get_field_name();

			// 字段NOT NULL属性
			boolean field_not_null = field_info.is_field_not_null();

			// 中文字段类型
			String field_type = field_info.get_field_type();
			// 英文字段名
			String translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_info.get_field_name());

			// 创建要插入的字段名以及注释
			if (field_items.hasNext()) {
				result.append("      sql.append(\""
						+ field_name
						+ ", \");"
						+ StringTools.getMargin(16 - translated_field_name
								.getBytes().length) + "//"
						+ translated_field_name + "\r");
			} else {
				result.append("      sql.append(\""
						+ translated_field_name
						+ ") \");"
						+ StringTools.getMargin(16 - 1 - translated_field_name
								.getBytes().length) + "//"
						+ translated_field_name + "\r");
			}

			if (firstTurn) {
				result.append("      sql.append(\"VALUES(\");\r");
				result.append("\r");
				firstTurn = false;
			}

			result.append("      //将字段『" + field_name + "』的信息加入SQL文\r");
			if (field_not_null) {
				result.append("      sql.append(");

				/*
				 * if (_sequence_table_name != null &&
				 * _sequence_table_name.length() > 0 &&
				 * _ch_field_key.equals(field_info.get_field_name())) {
				 * result.append("lng_key" + addCommaInsert(field_items) + ");
				 * \r"); } else {
				 * result.append(addSingleQuotesStart(ch_field_type) +
				 * "valueObj.get" + en_field_name + "()" +
				 * addSingleQuotesEnd(ch_field_type) +
				 * addCommaInsert(field_items) + "); \r"); }
				 */
			} else {

				result.append("      if (!valueObj.isEmpty"
						+ translated_field_name + "()) {\r");
				result.append("        sql.append("
						+ addSingleQuotesStart(field_type) + "valueObj.get"
						+ translated_field_name + "()"
						+ addSingleQuotesEnd(field_type)
						+ addCommaInsert(field_items) + "); \r");
				result.append("      } else {\r");
				result.append("        sql.append(\""
						+ getNullAndDefault(field_info) + "\""
						+ addCommaInsert(field_items) + "); \r");
				result.append("      }\r");
			}
			result.append("\r");
		}

		result.append(outputLogSql(methodName));

		result.append("      //执行操作将记录插入数据库\r");
		result.append("      stmt.executeUpdate(sql.toString());\r");
		result.append("\r");
		result.append("      //将插入记录的主键返回\r");
		result.append("      return lng_key;\r");

		result.append(outputMethodEnd(methodName));

		return result.toString();
	}

	/**
	 * 生成压要插入到DAO中的QueryExact方法
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createQueryExactMethod(String methodName) {

		StringBuffer result = new StringBuffer();

		result.append("  /**\r");
		result.append("   * 根据参数VO从表〖" + tableName
				+ "〗中的查询出满足条件的记录(对字段进行精确查询)\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ " query操作所需的参数\r");
		result.append("   * @return List 满足查询条件的记录\r");
		result.append("   * @Exception 当数据库操作发生异常时\r");
		result.append("   */\r");

		result.append(outputMethodBegin(methodName));

		result.append("    //SQL语句字符串缓冲变量\r");
		result.append("    StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("    //初始化SQL语句\r");
		result.append("    sql.append(\"SELECT \");\r");

		// 取得数据表的所有字段

		Iterator _ch_field_items = tableMeta.getFieldList().iterator();
		boolean firstTurn = true;
		while (_ch_field_items.hasNext()) {
			// 数据表的所有字段信息
			FieldMeta field_info = (FieldMeta) _ch_field_items.next();

			String field_name = field_info.get_field_name();
			String translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_name);

			// 中文字段类型
			String ch_field_type = field_info.get_field_type();
			// 创建要插入的字段名以及注释
			if (_ch_field_items.hasNext()) {
				result.append("    sql.append(\""
						+ field_info.get_field_name()
						+ ", \");"
						+ StringTools.getMargin(16 - field_info
								.get_field_name().getBytes().length) + "//"
						+ field_info.get_field_name() + "\r");
			} else {
				result.append("    sql.append(\""
						+ field_info.get_field_name()
						+ " \");"
						+ StringTools.getMargin(16 - 1 - field_info
								.get_field_name().getBytes().length) + "//"
						+ field_info.get_field_name() + "\r");
			}
			if (firstTurn) {
				result.append("    sql.append(\"FROM " + tableName + " \");\r");
				result.append("    sql.append(\"WHERE \");\r");
				firstTurn = false;
			}

			result.append("\r");
			result.append("    //将字段『" + field_name + "』的信息加入SQL文\r");
			result.append("    if (!valueObj.isEmpty" + translated_field_name
					+ "()) {\r");
			result.append("      sql.append(\"" + field_info.get_field_name()
					+ "=\");\r");
			result.append("      sql.append("
					+ addSingleQuotesStart(ch_field_type) + "valueObj.get"
					+ translated_field_name + "()"
					+ addSingleQuotesEnd(ch_field_type) + " + \" AND \"); \r");
			result.append("    }\r");
		}

		result.append("\r");

		result.append("    //去掉SQL文的最后一个'AND'\r");
		result.append("    String sqlExec = sql.toString();\r");
		result.append("    int index = sqlExec.lastIndexOf(\"AND\");\r");
		result.append("    sqlExec = sqlExec.substring(0, index).trim();\r");
		result.append("    \r");

		result.append(outputLogSql(methodName));

		result.append("      //定义返回的结果集列表\r");
		result.append("      ArrayList voList = new ArrayList();\r");
		result.append("\r");
		result.append("      //执行数据库操作\r");
		result.append("      ResultSet rset = stmt.executeQuery(sqlExec);\r");
		result.append("\r");
		result.append("      //循环处理结果集中的纪录\r");
		result.append("      VO_" + translatedTableName + " voItem = null;\r");
		result.append("      while (rset.next()) {\r");
		result.append("        //获得结果实例\r");
		result.append("        voItem = VO_" + translatedTableName
				+ ".getInstance(rset);\r");
		result.append("        //将结果加入结果列表\r");
		result.append("        voList.add(voItem);\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //返回结果集列表\r");
		result.append("      return voList;\r");

		result.append(outputMethodEnd(methodName));

		return result.toString();
	}

	/**
	 * 生成压要插入到DAO中的Query方法
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createQueryMethod(String methodName) {

		StringBuffer result = new StringBuffer();
		String tableName = tableMeta.getTableName();
		String translatedTableName = tableMeta.translate(tableMeta
				.getTableName());

		result.append("  /**\r");
		result.append("   * 根据参数VO从表〖" + tableName
				+ "〗中的查询出满足条件的记录(对字段进行模糊查询)\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ " query操作所需的参数\r");
		result.append("   * @return List 满足查询条件的记录\r");
		result.append("   * @Exception 当数据库操作发生异常时\r");
		result.append("   */\r");
		result.append(outputMethodBegin(methodName));
		result.append("    //SQL语句字符串缓冲变量\r");
		result.append("    StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("    //初始化SQL语句\r");
		result.append("    sql.append(\"SELECT \");\r");

		Iterator field_items = tableMeta.getFieldList().iterator();
		boolean firstTurn = true;
		while (field_items.hasNext()) {
			// 数据表的所有字段信息
			FieldMeta field_info = (FieldMeta) field_items.next();

			// 中文字段名
			String fieldName = field_info.get_field_name();
			String ch_field_type = field_info.get_field_type();

			// 英文字段名
			String translatedFieldName = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + fieldName);

			// 创建要插入的字段名以及注释
			if (field_items.hasNext()) {
				result.append("    sql.append(\""
						+ field_info.get_field_name()
						+ ", \");"
						+ StringTools.getMargin(16 - field_info
								.get_field_name().getBytes().length) + "//"
						+ field_info.get_field_name() + "\r");
			} else {
				result.append("    sql.append(\""
						+ field_info.get_field_name()
						+ " \");"
						+ StringTools.getMargin(16 - 1 - field_info
								.get_field_name().getBytes().length) + "//"
						+ field_info.get_field_name() + "\r");
			}
			if (firstTurn) {
				result.append("    sql.append(\"FROM " + tableName + " \");\r");
				result.append("    sql.append(\"WHERE \");\r");
				firstTurn = false;
			}

			result.append("\r");
			result.append("    //将字段『" + field_info.get_field_name()
					+ "』的信息加入SQL文\r");
			result.append("    if (!valueObj.isEmpty" + translatedFieldName
					+ "()) {\r");

			String java_type = getJavaType(ch_field_type);
			if (java_type.equals("String")) {
				result.append("      sql.append(\""
						+ field_info.get_field_name() + " LIKE \");\r");
			} else {
				result.append("      sql.append(\""
						+ field_info.get_field_name() + "=\");\r");
			}
			result.append("      sql.append(" + addLikeStart(ch_field_type)
					+ "valueObj.get" + translatedFieldName + "()"
					+ addLikeEnd(ch_field_type) + " + \" AND \"); \r");
			result.append("    }\r");
		}

		result.append("\r");

		result.append("    //去掉SQL文的最后一个'AND'\r");
		result.append("    String sqlExec = sql.toString();\r");
		result.append("    int index = sqlExec.lastIndexOf(\"AND\");\r");
		result.append("    sqlExec = sqlExec.substring(0, index).trim();\r");
		result.append("    \r");
		result.append(outputLogSql(methodName));

		result.append("      //定义返回的结果集列表\r");
		result.append("      ArrayList voList = new ArrayList();\r");
		result.append("\r");
		result.append("      //执行数据库操作\r");
		result.append("      ResultSet rset = stmt.executeQuery(sqlExec);\r");
		result.append("\r");
		result.append("      //循环处理结果集中的纪录\r");
		result.append("      VO_" + translatedTableName + " voItem = null;\r");
		result.append("      while (rset.next()) {\r");
		result.append("        //获得结果实例\r");
		result.append("        voItem = VO_" + translatedTableName
				+ ".getInstance(rset);\r");
		result.append("        //将结果加入结果列表\r");
		result.append("        voList.add(voItem);\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //返回结果集列表\r");
		result.append("      return voList;\r");

		result.append(outputMethodEnd(methodName));
		return result.toString();
	}

	/**
	 * 生成压要插入到DAO中的UpdateByField方法
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createUpdateByFieldMethod(String methodName) {

		StringBuffer result = new StringBuffer();

		result.append("  /**\r");
		result.append("   * 根据参数VO[]更新表〖" + tableName + "〗, 只更新VO中设定了值的字段\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ "[] update操作所需的参数\r");
		result.append("   * @return int 数据库中成功update的条数\r");
		result.append("   * @Exception 当数据库操作发生异常时\r");
		result.append("   */\r");

		result.append(outputMethodBegin(methodName));

		result.append("\r");
		result.append("      for (int i = 0; i < valueObj.length; i++) {\r");
		result.append("\r");
		result.append(outputKeyFieldValidate());
		result.append("\r");
		result.append("        //SQL语句字符串缓冲变量\r");
		result.append("        StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("        //初始化SQL语句\r");
		result.append("        sql.append(\"UPDATE \");\r");
		result.append("        sql.append(\"" + tableName + " SET \");\r");

		// 字段类型
		String field_type = null;
		Iterator field_items = tableMeta.getFieldList().iterator();
		while (field_items.hasNext()) {
			// 数据表的所有字段信息
			FieldMeta field_info = (FieldMeta) field_items.next();

			// 中文字段名
			String field_name = field_info.get_field_name();

			// 英文字段名
			String translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_name);

			// 中文字段类型
			field_type = field_info.get_field_type();
			field_type = field_type.toUpperCase();

			List keyFieldList = tableMeta.getKeyFieldList();
			if (!keyFieldList.equals(field_info.get_field_name())) {
				result.append("        //将字段『" + field_info.get_field_name()
						+ "』的信息加入SQL文\r");
				result.append("        if (!valueObj[i].isEmpty"
						+ translated_field_name + "()) {\r");
				result.append("          sql.append(\""
						+ field_info.get_field_name() + "=\");\r");
				result.append("          sql.append("
						+ addSingleQuotesStart(field_type) + "valueObj[i].get"
						+ translated_field_name + "()"
						+ addSingleQuotesEnd(field_type)
						+ addCommaUpdateByField(field_items) + "); \r");
				result.append("        }\r");
			}
			// FIXME
			result.append("\r");
		}

		result.append("        sql.append(\" \");\r");
		result.append(outputKeyFieldCondition());

		result.append("        //去掉SQL文的最后一个逗号\r");
		result.append("        String sqlExec = sql.toString();\r");
		result.append("        int index = sqlExec.lastIndexOf(\",\");\r");
		result
				.append("        sqlExec = sqlExec.substring(0, index) + sqlExec.substring(index + 1);\r");
		result.append("\r");

		result.append(outputLogSql(methodName));
		result.append("    //成功插入记录的条数\r");
		result.append("    int update_count = 0;\r");
		result.append("\r");
		result.append("        //将更新的记录条数进行累加\r");
		result.append("        update_count += stmt.executeUpdate(sqlExec);\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //返回插入成功插入数据库的记录条数\r");
		result.append("      return update_count;\r");
		result.append("\r");
		result.append("    } catch(Exception e) {\r");
		result.append("\r");
		result.append("      //将错误信息进行Log处理\r");
		result.append("      logger.error (\"<VO_" + translatedTableName + "."
				+ methodName + "> \"" + " + e);\r");
		result.append("\r");
		result.append("      //错误处理\r");
		result.append("      throw e;\r");
		result.append("    } finally {\r");
		result.append("\r");
		result.append("      //释放数据库语句资源\r");
		result.append("      if (stmt != null) {\r");
		result.append("        stmt.close();\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //断开数据库连接\r");
		result.append("      disconnectDB();\r");
		result.append("    }\r");
		result.append("  }\r");

		return result.toString();
	}

	/**
	 * 生成压要插入到DAO中的Update方法
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createUpdateMethod(String methodName) {

		StringBuffer result = new StringBuffer();

		result.append("  /**\r");
		result.append("   * 根据参数VO[]更新表〖" + tableName
				+ "〗, 如果VO中的字段没有设定值, 则为其赋上初值\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ "[] update操作所需的参数\r");
		result.append("   * @return int 数据库中成功update的条数\r");
		result.append("   * @Exception 当数据库操作发生异常时\r");
		result.append("   */\r");
		result.append(outputMethodBegin(methodName));

		result.append("      for (int i = 0; i < valueObj.length; i++) {\r");
		result.append("\r");

		result.append(outputKeyFieldValidate());

		result.append("\r");
		result.append("        //SQL语句字符串缓冲变量\r");
		result.append("        StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("        //初始化SQL语句\r");
		result.append("        sql.append(\"UPDATE \");\r");
		result.append("        sql.append(\"" + tableMeta.getTableName()
				+ " SET \");\r");

		// 取得数据表的所有字段
		FieldMeta field_info = null;
		String field_name = null;
		String translated_field_name = null;
		// 字段类型
		String ch_field_type = null;

		Iterator field_items = tableMeta.getFieldList().iterator();
		while (field_items.hasNext()) {
			// 数据表的所有字段信息
			field_info = (FieldMeta) field_items.next();

			// 中文字段名
			field_name = field_info.get_field_name();

			// 英文字段名
			translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_name);

			// 字段NOT NULL属性
			boolean field_not_null = field_info.is_field_not_null();

			// 中文字段类型
			ch_field_type = field_info.get_field_type().toUpperCase();
			List keyFieldList = tableMeta.getFieldList();
			if (!keyFieldList.contains(field_info.get_field_name())) {
				result.append("        //将字段『" + field_info.get_field_name()
						+ "』的信息加入SQL文\r");
				if (field_not_null) {
					result.append("        sql.append(\""
							+ field_info.get_field_name() + "=\" + ");
					result.append(addSingleQuotesStart(ch_field_type)
							+ "valueObj[i].get" + translated_field_name + "()"
							+ addSingleQuotesEnd(ch_field_type)
							+ addCommaUpdate(field_items) + "); \r");
				} else {
					result.append("        sql.append(\""
							+ field_info.get_field_name() + "=\");\r");
					result.append("        if (!valueObj[i].isEmpty"
							+ translated_field_name + "()) {\r");
					result.append("          sql.append("
							+ addSingleQuotesStart(ch_field_type)
							+ "valueObj[i].get" + translated_field_name + "()"
							+ addSingleQuotesEnd(ch_field_type)
							+ addCommaUpdate(field_items) + "); \r");
					result.append("        } else {\r");
					result.append("          sql.append(\""
							+ getNullAndDefault(field_info) + "\""
							+ addCommaUpdate(field_items) + "); \r");
					result.append("        }\r");
				}
			}
			result.append("\r");
		}

		result.append("        sql.append(\" \");\r");
		result.append(outputKeyFieldCondition());
		result.append("\r");

		result.append(outputLogSql(methodName));

		result.append("    //成功更新记录的条数\r");
		result.append("    int update_count = 0;\r");
		result.append("\r");
		result.append("        //对更新的记录条数进行累加\r");
		result
				.append("        update_count += stmt.executeUpdate(sql.toString());\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //返回插入成功更新数据库的记录条数\r");
		result.append("      return update_count;\r");

		result.append(result.append(outputMethodEnd(methodName)));

		return result.toString();
	}

	/**
	 * 如果该字段有default值,则返回default值,否则返回null
	 * 
	 * @param field_info
	 *            VOTableInfo
	 * @return String
	 */
	private String getNullAndDefault(FieldMeta field_info) {

		// 字段default值
		String field_default_value = field_info.get_field_default_value();
		if(field_default_value==null)return null;
		// 中文字段类型
		String ch_field_type = field_info.get_field_type();

		// 取得字段对应的java类型
		String java_type = getJavaType(ch_field_type);

		String result = "";
		// 如果有default值
		if (field_default_value.trim().length() > 0) {
			if (java_type.equals("String")) {
				if (ch_field_type.toUpperCase().equals("DATE")) {
					result = field_default_value;
				} else {
					result = "'" + field_default_value + "'";
				}
			} else if (java_type.equals("double")) {
				result = field_default_value;
			} else if (java_type.equals("long")) {
				result = field_default_value;
			} else if (java_type.equals("Date")) {
				result = "sysdate";
			}
		} else {
			if (ch_field_type.toUpperCase().equals("DATE")) {
				result = "sysdate";
			} else {
				result = null;
			}
		}

		return result;
	}

	private String outputKeyFieldCondition() {
		StringBuffer result = new StringBuffer();
		result.append("        //根据主键信息来设定更新条件\r");
		result.append("        sql.append(\"WHERE \");\r");
		List keyFieldList = tableMeta.getKeyFieldList();
		for (int i = 0, j = keyFieldList.size(); i < j; i++) {
			String strKeyFieldName = keyFieldList.get(i).toString();
			String strTranslatedKeyFieldName = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + strKeyFieldName);

			result.append("        sql.append(\"" + strKeyFieldName
					+ "='\");\r");
			result.append("        sql.append(valueObj[i].get"
					+ strTranslatedKeyFieldName + "());\r");
			result.append("        sql.append(\"'\");\r");

		}
		return result.toString();
	}

	private String outputKeyFieldValidate() {
		StringBuffer result = new StringBuffer();
		result.append("        //判断传入的VO中的主键字段是否为空\r");
		List keyFieldList = tableMeta.getKeyFieldList();
		for (int i = 0, j = keyFieldList.size(); i < j; i++) {
			String strKeyFieldName = keyFieldList.get(i).toString();
			String strTranslatedKeyFieldName = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + strKeyFieldName);

			result.append("        if(valueObj[i].isEmpty"
					+ strTranslatedKeyFieldName + "()) {\r");
			result.append("          throw new " + "(\"更新表〖"
					+ tableMeta.getTableName() + "〗时, 缺少主键『" + strKeyFieldName
					+ "』\");\r");
			result.append("        }\r");
		}
		return result.toString();
	}

	private String outputMethodBegin(String methodName) {
		StringBuffer result = new StringBuffer();
		result.append("  public long " + methodName + "(VO_"
				+ translatedTableName + " valueObj) throws Exception {\r");
		result.append("\r");
		result.append("    //创建Statement对象\r");
		result.append("    Statement stmt = null;\r");
		result.append("\r");

		result.append("    try {\r");
		result.append("      //连接数据库\r");
		result.append("      connectDB();\r");
		result.append("\r");
		result.append("      //创建数据库操作语句\r");
		result.append("      stmt = connection.createStatement();\r");
		;
		result.append("\r");
		return result.toString();
	}

	private String outputMethodEnd(String methodName) {
		StringBuffer result = new StringBuffer();

		result.append("\r");
		result.append("    } catch(Exception e) {\r");
		result.append("\r");
		result.append("      //将错误信息进行Log处理\r");
		result.append("      logger.error (\"<VO_" + translatedTableName + "."
				+ methodName + "> \"" + " + e);\r");
		result.append("\r");
		result.append("      //错误处理\r");
		result.append("      throw e;\r");
		result.append("    } finally {\r");
		result.append("\r");
		result.append("      //释放数据库语句资源\r");
		result.append("      if (stmt != null) {\r");
		result.append("        stmt.close();\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //断开数据库连接\r");
		result.append("      disconnectDB();\r");
		result.append("    }\r");
		result.append("  }\r");
		return result.toString();
	}

	private String outputLogSql(String methodName) {

		StringBuffer result = new StringBuffer();
		result.append("\r");
		result.append("        //将调试信息进行Log处理\r");
		result.append("        logger.info(\"<DAO_" + translatedTableName + "."
				+ methodName + "> \" + sqlExec);\r");
		result.append("\r");
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

}
