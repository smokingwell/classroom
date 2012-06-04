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
import java.util.List;

import mytools.util.StringTools;

/**
 * Ĭ�ϵ�DA������������
 * 
 * 
 */

public class MysqlDAOCodeWorker extends BaseDAOWorker {
	/**
	 * ����ʱ,����������һ���ֶ�,�򷵻� + "," ��֮,�򷵻� + )
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
	 * ����,�����û�е����һ���ֶ�,�򷵻� + "," ��֮,�򷵻� +
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
	 * ����(�ֶ�),���� + ","
	 * 
	 * @param field_items
	 *            Iterator
	 * @return String
	 */
	private String addCommaUpdateByField(Iterator field_items) {
		return " + \", \"";
	}

	/**
	 * ����ֶε�������String��,�򷵻� + "%'" ��֮, �򷵻ؿ�
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
	 * ����ֶε�������String��,�򷵻� "LIKE '%" + ��֮, �򷵻ؿ�
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
	 * ����ֶε�������String��,�򷵻� + "'" ��֮, �򷵻ؿ�
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
	 * ����ֶε�������String��,�򷵻� "'" + ��֮, �򷵻ؿ�
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
	 * ����ѹҪ���뵽DAO�е�Delete����
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
		result.append("   * ���ݲ���VO[]ɾ����" + tableName + "���е���Ӧ��¼\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ "[] delete��������Ĳ���\r");
		result.append("   * @return int ���ݿ��гɹ�delete������\r");
		result.append("   * @Exception �����ݿ���������쳣ʱ\r");
		result.append("   */\r");
		
		result.append(outputMethodBegin(methodName));

		result.append("      for (int i = 0; i < valueObj.length; i++) {\r");
		result.append("        //SQL����ַ����������\r");
		result.append("        StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("        //��ʼ��SQL���\r");
		result.append("        sql.append(\"DELETE \");\r");
		result.append("        sql.append(\"" + tableName + " WHERE \");\r");

		// ȡ�����ݱ�������ֶ�
		Iterator _ch_field_items = tableMeta.getFieldList().iterator();
		while (_ch_field_items.hasNext()) {
			// ���ݱ�������ֶ���Ϣ
			FieldMeta field_info = (FieldMeta) _ch_field_items.next();

			String field_name = field_info.get_field_name();
			String translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_name);

			// �����ֶ�����
			String ch_field_type = field_info.get_field_type();

			result.append("\r");
			result.append("        //���ֶΡ�" + field_info.get_field_name()
					+ "������Ϣ����SQL��\r");
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

		result.append("        //ȥ��SQL�ĵ����һ��'AND'\r");
		result.append("        String sqlExec = sql.toString();\r");
		result.append("        int index = sqlExec.lastIndexOf(\"AND\");\r");
		result
				.append("        sqlExec = sqlExec.substring(0, index).trim();\r");

		result.append(outputLogSql(methodName));
		result.append("        //�����µļ�¼���������ۼ�\r");
		result.append("        delete_count += stmt.executeUpdate(sqlExec);\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //���ز���ɹ��������ݿ�ļ�¼����\r");
		result.append("      return delete_count;\r");

		result.append(outputMethodEnd(methodName));

		return result.toString();
	}

	/**
	 * ����Ҫ���뵽DAO�е�Insert����
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createInsertMethod(String methodName) {

		StringBuffer result = new StringBuffer();

		result.append("  /**\r");
		result.append("   * ������VO[]�е����ݲ��뵽��" + tableName + "����\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ "[] insert��������Ĳ���\r");
		result.append("   * @return int insert�����ݿ��е�����\r");
		result.append("   * @Exception �����ݿ���������쳣ʱ\r");
		result.append("   */\r");

		result.append(outputMethodBegin(methodName));
		result.append("      for (int i = 0; i < valueObj.length; i++) {\r");

		result.append("        //SQL����ַ����������\r");
		result.append("        StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("        //��ʼ��SQL���\r");
		result.append("        sql.append(\"INSERT INTO \");\r");
		result.append("        sql.append(\"" + tableName + "(\");\r");

		// ȡ�����ݱ�������ֶ�

		Iterator _ch_field_items = tableMeta.getFieldList().iterator();
		boolean firstTurn = true;
		while (_ch_field_items.hasNext()) {
			// ���ݱ�������ֶ���Ϣ
			FieldMeta field_info = (FieldMeta) _ch_field_items.next();

			// Ӣ���ֶ���
			String translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_info.get_field_name());

			// �����ֶ�����
			String ch_field_type = field_info.get_field_type();
			boolean field_not_null = field_info.is_field_not_null();

			// ����Ҫ������ֶ����Լ�ע��
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

			result.append("        //���ֶΡ�" + field_info.get_field_name()
					+ "������Ϣ����SQL��\r");
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

		result.append("      //ִ�в�������¼�������ݿ�\r");
		result.append("      stmt.executeUpdate(sql.toString());\r");
		result.append("\r");
		result.append("      //�������¼����������\r");
		result.append("      return lng_key;\r");

		result.append(outputMethodEnd(methodName));
		return result.toString();
	}

	/**
	 * ����Ҫ���뵽DAO�е�Insert_PK����
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createInsertPKMethod(String methodName) {

		StringBuffer result = new StringBuffer();

		result.append("  /**\r");
		result.append("   * ������VO�е����ݲ��뵽��" + tableMeta.getTableName()
				+ "����,\r");
		result.append("   * �������������¼������\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ " insert��������Ĳ���\r");
		result.append("   * @return long ��insert��¼������\r");
		result.append("   * @Exception �����ݿ���������쳣ʱ\r");
		result.append("   */\r");

		result.append(outputMethodBegin(methodName));
		/*
		 * result.append(" //SQL����ַ����������\r"); result.append(" StringBuffer
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
		 * result.append(" //��������Ϣ����Log����\r"); result.append( " logger.info(\"<DAO_"
		 * +translatedTableName + "." + methodName + "> \" +
		 * sql_seq.toString());\r"); result.append("\r"); result.append("
		 * //ִ�����ݿ����\r"); result.append( " ResultSet rset =
		 * stmt.executeQuery(sql_seq.toString());\r"); result.append(" long
		 * lng_key = -1;\r"); result.append(" if(rset.next()){\r");
		 * result.append(" lng_key = rset.getLong(\"max\");\r"); result.append("
		 * //��������Ϣ����Log����\r"); result.append(" logger.info(\"<DAO_" +
		 * translatedTableName+ "." + methodName + "> ȡ������:\" + lng_key);\r");
		 * result.append(" }\r"); result.append("\r");
		 * 
		 */
		result.append("      //SQL����ַ����������\r");
		result.append("      StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("      //��ʼ��SQL���\r");
		result.append("      sql.append(\"INSERT INTO \");\r");
		result.append("      sql.append(\"" + tableMeta.getTableName()
				+ "(\");\r");

		// ȡ�����ݱ�������ֶ�

		Iterator field_items = tableMeta.getFieldList().iterator();
		boolean firstTurn = true;
		while (field_items.hasNext()) {
			// ���ݱ�������ֶ���Ϣ
			FieldMeta field_info = (FieldMeta) field_items.next();

			// �����ֶ���
			String field_name = field_info.get_field_name();

			// �ֶ�NOT NULL����
			boolean field_not_null = field_info.is_field_not_null();

			// �����ֶ�����
			String field_type = field_info.get_field_type();
			// Ӣ���ֶ���
			String translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_info.get_field_name());

			// ����Ҫ������ֶ����Լ�ע��
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

			result.append("      //���ֶΡ�" + field_name + "������Ϣ����SQL��\r");
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

		result.append("      //ִ�в�������¼�������ݿ�\r");
		result.append("      stmt.executeUpdate(sql.toString());\r");
		result.append("\r");
		result.append("      //�������¼����������\r");
		result.append("      return lng_key;\r");

		result.append(outputMethodEnd(methodName));

		return result.toString();
	}

	/**
	 * ����ѹҪ���뵽DAO�е�QueryExact����
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createQueryExactMethod(String methodName) {

		StringBuffer result = new StringBuffer();

		result.append("  /**\r");
		result.append("   * ���ݲ���VO�ӱ�" + tableName
				+ "���еĲ�ѯ�����������ļ�¼(���ֶν��о�ȷ��ѯ)\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ " query��������Ĳ���\r");
		result.append("   * @return List �����ѯ�����ļ�¼\r");
		result.append("   * @Exception �����ݿ���������쳣ʱ\r");
		result.append("   */\r");

		result.append(outputMethodBegin(methodName));

		result.append("    //SQL����ַ����������\r");
		result.append("    StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("    //��ʼ��SQL���\r");
		result.append("    sql.append(\"SELECT \");\r");

		// ȡ�����ݱ�������ֶ�

		Iterator _ch_field_items = tableMeta.getFieldList().iterator();
		boolean firstTurn = true;
		while (_ch_field_items.hasNext()) {
			// ���ݱ�������ֶ���Ϣ
			FieldMeta field_info = (FieldMeta) _ch_field_items.next();

			String field_name = field_info.get_field_name();
			String translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_name);

			// �����ֶ�����
			String ch_field_type = field_info.get_field_type();
			// ����Ҫ������ֶ����Լ�ע��
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
			result.append("    //���ֶΡ�" + field_name + "������Ϣ����SQL��\r");
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

		result.append("    //ȥ��SQL�ĵ����һ��'AND'\r");
		result.append("    String sqlExec = sql.toString();\r");
		result.append("    int index = sqlExec.lastIndexOf(\"AND\");\r");
		result.append("    sqlExec = sqlExec.substring(0, index).trim();\r");
		result.append("    \r");

		result.append(outputLogSql(methodName));

		result.append("      //���巵�صĽ�����б�\r");
		result.append("      ArrayList voList = new ArrayList();\r");
		result.append("\r");
		result.append("      //ִ�����ݿ����\r");
		result.append("      ResultSet rset = stmt.executeQuery(sqlExec);\r");
		result.append("\r");
		result.append("      //ѭ�����������еļ�¼\r");
		result.append("      VO_" + translatedTableName + " voItem = null;\r");
		result.append("      while (rset.next()) {\r");
		result.append("        //��ý��ʵ��\r");
		result.append("        voItem = VO_" + translatedTableName
				+ ".getInstance(rset);\r");
		result.append("        //������������б�\r");
		result.append("        voList.add(voItem);\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //���ؽ�����б�\r");
		result.append("      return voList;\r");

		result.append(outputMethodEnd(methodName));

		return result.toString();
	}

	/**
	 * ����ѹҪ���뵽DAO�е�Query����
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
		result.append("   * ���ݲ���VO�ӱ�" + tableName
				+ "���еĲ�ѯ�����������ļ�¼(���ֶν���ģ����ѯ)\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ " query��������Ĳ���\r");
		result.append("   * @return List �����ѯ�����ļ�¼\r");
		result.append("   * @Exception �����ݿ���������쳣ʱ\r");
		result.append("   */\r");
		result.append(outputMethodBegin(methodName));
		result.append("    //SQL����ַ����������\r");
		result.append("    StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("    //��ʼ��SQL���\r");
		result.append("    sql.append(\"SELECT \");\r");

		Iterator field_items = tableMeta.getFieldList().iterator();
		boolean firstTurn = true;
		while (field_items.hasNext()) {
			// ���ݱ�������ֶ���Ϣ
			FieldMeta field_info = (FieldMeta) field_items.next();

			// �����ֶ���
			String fieldName = field_info.get_field_name();
			String ch_field_type = field_info.get_field_type();

			// Ӣ���ֶ���
			String translatedFieldName = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + fieldName);

			// ����Ҫ������ֶ����Լ�ע��
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
			result.append("    //���ֶΡ�" + field_info.get_field_name()
					+ "������Ϣ����SQL��\r");
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

		result.append("    //ȥ��SQL�ĵ����һ��'AND'\r");
		result.append("    String sqlExec = sql.toString();\r");
		result.append("    int index = sqlExec.lastIndexOf(\"AND\");\r");
		result.append("    sqlExec = sqlExec.substring(0, index).trim();\r");
		result.append("    \r");
		result.append(outputLogSql(methodName));

		result.append("      //���巵�صĽ�����б�\r");
		result.append("      ArrayList voList = new ArrayList();\r");
		result.append("\r");
		result.append("      //ִ�����ݿ����\r");
		result.append("      ResultSet rset = stmt.executeQuery(sqlExec);\r");
		result.append("\r");
		result.append("      //ѭ�����������еļ�¼\r");
		result.append("      VO_" + translatedTableName + " voItem = null;\r");
		result.append("      while (rset.next()) {\r");
		result.append("        //��ý��ʵ��\r");
		result.append("        voItem = VO_" + translatedTableName
				+ ".getInstance(rset);\r");
		result.append("        //������������б�\r");
		result.append("        voList.add(voItem);\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //���ؽ�����б�\r");
		result.append("      return voList;\r");

		result.append(outputMethodEnd(methodName));
		return result.toString();
	}

	/**
	 * ����ѹҪ���뵽DAO�е�UpdateByField����
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createUpdateByFieldMethod(String methodName) {

		StringBuffer result = new StringBuffer();

		result.append("  /**\r");
		result.append("   * ���ݲ���VO[]���±�" + tableName + "��, ֻ����VO���趨��ֵ���ֶ�\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ "[] update��������Ĳ���\r");
		result.append("   * @return int ���ݿ��гɹ�update������\r");
		result.append("   * @Exception �����ݿ���������쳣ʱ\r");
		result.append("   */\r");

		result.append(outputMethodBegin(methodName));

		result.append("\r");
		result.append("      for (int i = 0; i < valueObj.length; i++) {\r");
		result.append("\r");
		result.append(outputKeyFieldValidate());
		result.append("\r");
		result.append("        //SQL����ַ����������\r");
		result.append("        StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("        //��ʼ��SQL���\r");
		result.append("        sql.append(\"UPDATE \");\r");
		result.append("        sql.append(\"" + tableName + " SET \");\r");

		// �ֶ�����
		String field_type = null;
		Iterator field_items = tableMeta.getFieldList().iterator();
		while (field_items.hasNext()) {
			// ���ݱ�������ֶ���Ϣ
			FieldMeta field_info = (FieldMeta) field_items.next();

			// �����ֶ���
			String field_name = field_info.get_field_name();

			// Ӣ���ֶ���
			String translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_name);

			// �����ֶ�����
			field_type = field_info.get_field_type();
			field_type = field_type.toUpperCase();

			List keyFieldList = tableMeta.getKeyFieldList();
			if (!keyFieldList.equals(field_info.get_field_name())) {
				result.append("        //���ֶΡ�" + field_info.get_field_name()
						+ "������Ϣ����SQL��\r");
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

		result.append("        //ȥ��SQL�ĵ����һ������\r");
		result.append("        String sqlExec = sql.toString();\r");
		result.append("        int index = sqlExec.lastIndexOf(\",\");\r");
		result
				.append("        sqlExec = sqlExec.substring(0, index) + sqlExec.substring(index + 1);\r");
		result.append("\r");

		result.append(outputLogSql(methodName));
		result.append("    //�ɹ������¼������\r");
		result.append("    int update_count = 0;\r");
		result.append("\r");
		result.append("        //�����µļ�¼���������ۼ�\r");
		result.append("        update_count += stmt.executeUpdate(sqlExec);\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //���ز���ɹ��������ݿ�ļ�¼����\r");
		result.append("      return update_count;\r");
		result.append("\r");
		result.append("    } catch(Exception e) {\r");
		result.append("\r");
		result.append("      //��������Ϣ����Log����\r");
		result.append("      logger.error (\"<VO_" + translatedTableName + "."
				+ methodName + "> \"" + " + e);\r");
		result.append("\r");
		result.append("      //������\r");
		result.append("      throw e;\r");
		result.append("    } finally {\r");
		result.append("\r");
		result.append("      //�ͷ����ݿ������Դ\r");
		result.append("      if (stmt != null) {\r");
		result.append("        stmt.close();\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //�Ͽ����ݿ�����\r");
		result.append("      disconnectDB();\r");
		result.append("    }\r");
		result.append("  }\r");

		return result.toString();
	}

	/**
	 * ����ѹҪ���뵽DAO�е�Update����
	 * 
	 * @param methodName
	 *            String
	 * @return String
	 */
	public String createUpdateMethod(String methodName) {

		StringBuffer result = new StringBuffer();

		result.append("  /**\r");
		result.append("   * ���ݲ���VO[]���±�" + tableName
				+ "��, ���VO�е��ֶ�û���趨ֵ, ��Ϊ�丳�ϳ�ֵ\r");
		result.append("   * \r");
		result.append("   * @param VO_" + translatedTableName
				+ "[] update��������Ĳ���\r");
		result.append("   * @return int ���ݿ��гɹ�update������\r");
		result.append("   * @Exception �����ݿ���������쳣ʱ\r");
		result.append("   */\r");
		result.append(outputMethodBegin(methodName));

		result.append("      for (int i = 0; i < valueObj.length; i++) {\r");
		result.append("\r");

		result.append(outputKeyFieldValidate());

		result.append("\r");
		result.append("        //SQL����ַ����������\r");
		result.append("        StringBuffer sql = new StringBuffer();\r");
		result.append("\r");
		result.append("        //��ʼ��SQL���\r");
		result.append("        sql.append(\"UPDATE \");\r");
		result.append("        sql.append(\"" + tableMeta.getTableName()
				+ " SET \");\r");

		// ȡ�����ݱ�������ֶ�
		FieldMeta field_info = null;
		String field_name = null;
		String translated_field_name = null;
		// �ֶ�����
		String ch_field_type = null;

		Iterator field_items = tableMeta.getFieldList().iterator();
		while (field_items.hasNext()) {
			// ���ݱ�������ֶ���Ϣ
			field_info = (FieldMeta) field_items.next();

			// �����ֶ���
			field_name = field_info.get_field_name();

			// Ӣ���ֶ���
			translated_field_name = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + field_name);

			// �ֶ�NOT NULL����
			boolean field_not_null = field_info.is_field_not_null();

			// �����ֶ�����
			ch_field_type = field_info.get_field_type().toUpperCase();
			List keyFieldList = tableMeta.getFieldList();
			if (!keyFieldList.contains(field_info.get_field_name())) {
				result.append("        //���ֶΡ�" + field_info.get_field_name()
						+ "������Ϣ����SQL��\r");
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

		result.append("    //�ɹ����¼�¼������\r");
		result.append("    int update_count = 0;\r");
		result.append("\r");
		result.append("        //�Ը��µļ�¼���������ۼ�\r");
		result
				.append("        update_count += stmt.executeUpdate(sql.toString());\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //���ز���ɹ��������ݿ�ļ�¼����\r");
		result.append("      return update_count;\r");

		result.append(result.append(outputMethodEnd(methodName)));

		return result.toString();
	}

	/**
	 * ������ֶ���defaultֵ,�򷵻�defaultֵ,���򷵻�null
	 * 
	 * @param field_info
	 *            VOTableInfo
	 * @return String
	 */
	private String getNullAndDefault(FieldMeta field_info) {

		// �ֶ�defaultֵ
		String field_default_value = field_info.get_field_default_value();
		if(field_default_value==null)return null;
		// �����ֶ�����
		String ch_field_type = field_info.get_field_type();

		// ȡ���ֶζ�Ӧ��java����
		String java_type = getJavaType(ch_field_type);

		String result = "";
		// �����defaultֵ
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
		result.append("        //����������Ϣ���趨��������\r");
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
		result.append("        //�жϴ����VO�е������ֶ��Ƿ�Ϊ��\r");
		List keyFieldList = tableMeta.getKeyFieldList();
		for (int i = 0, j = keyFieldList.size(); i < j; i++) {
			String strKeyFieldName = keyFieldList.get(i).toString();
			String strTranslatedKeyFieldName = tableMeta.translate(tableMeta
					.getTableName()
					+ "." + strKeyFieldName);

			result.append("        if(valueObj[i].isEmpty"
					+ strTranslatedKeyFieldName + "()) {\r");
			result.append("          throw new " + "(\"���±�"
					+ tableMeta.getTableName() + "��ʱ, ȱ��������" + strKeyFieldName
					+ "��\");\r");
			result.append("        }\r");
		}
		return result.toString();
	}

	private String outputMethodBegin(String methodName) {
		StringBuffer result = new StringBuffer();
		result.append("  public long " + methodName + "(VO_"
				+ translatedTableName + " valueObj) throws Exception {\r");
		result.append("\r");
		result.append("    //����Statement����\r");
		result.append("    Statement stmt = null;\r");
		result.append("\r");

		result.append("    try {\r");
		result.append("      //�������ݿ�\r");
		result.append("      connectDB();\r");
		result.append("\r");
		result.append("      //�������ݿ�������\r");
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
		result.append("      //��������Ϣ����Log����\r");
		result.append("      logger.error (\"<VO_" + translatedTableName + "."
				+ methodName + "> \"" + " + e);\r");
		result.append("\r");
		result.append("      //������\r");
		result.append("      throw e;\r");
		result.append("    } finally {\r");
		result.append("\r");
		result.append("      //�ͷ����ݿ������Դ\r");
		result.append("      if (stmt != null) {\r");
		result.append("        stmt.close();\r");
		result.append("      }\r");
		result.append("\r");
		result.append("      //�Ͽ����ݿ�����\r");
		result.append("      disconnectDB();\r");
		result.append("    }\r");
		result.append("  }\r");
		return result.toString();
	}

	private String outputLogSql(String methodName) {

		StringBuffer result = new StringBuffer();
		result.append("\r");
		result.append("        //��������Ϣ����Log����\r");
		result.append("        logger.info(\"<DAO_" + translatedTableName + "."
				+ methodName + "> \" + sqlExec);\r");
		result.append("\r");
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

}
