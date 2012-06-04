/*
 * VOTableInfo.java
 *
 * ���ܣ����ݱ��ļ�������Ϣ�洢��.
 * ������VOTableInfo
 *
 *   ver    �����        ��˾     ������    �������
 * ��������������������������������������������������������������������
 *  V1.00  '04-04-21  �� (SURE)    ������    ����
 *
 * Copyright (c) 2004 Surekam corporation All Rights Reserved.
 */

package mytools.daomaker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * DDL�����ļ�����������
 * 
 * ע�⣺����������Լ����ʹ��һ�б�ʾ�������޷���ȷ����
 * @author zhangcheng
 *
 */
public class TableMeta {
  Logger logger=Logger.getLogger(TableMeta.class);	
  //���ע��
  private String _table_comment = "";

  //���ı���
  private String _table_name = "";
  
  
 //���ݱ������
  private List _key_field_list;

  //���ݱ�������ֶ���Ϣ
  private List _field_list = null;

  //��Ӣ���ֶεĶ�Ӧ��ϵ
  private static Translator translator = null;

  /**
   * ���캯��
   */
  public TableMeta(String ddl_file_path) {
	  loadDDL(ddl_file_path);	  
  }
  /**
   * ���캯��
   */
  public TableMeta(String ddl_file_path,Translator trans) {
	  loadDDL(ddl_file_path);
	  if(translator==null)translator=trans;
  }  
 
private void loadDDL(String ddl_file_path){
	  
	  new DDLParser().parseDDL(ddl_file_path);
  }

  /**
   * ���ע�͵�ȡ��
   */
  public String getTableComment() {
    return this._table_comment;
  }

 
  /**
   * ���ı�����ȡ��
   */
  public String getTableName() {
    return this._table_name;
  }

 
  /**
   * Ӣ�ı�����ȡ��
   */
  public String translate(String name) {
    /*return this._en_table_name;*/
	  if(translator==null)return name;
	  String result=name;
	  if(!name.equals(this._table_name)){
		  name=this._table_name+"."+name;
	  }
 
	  result=translator.translate(name);
	  return result;
  } 

  /**
   * ���ݱ��������ȡ��
   */
 public List getKeyFieldList() {
    return this._key_field_list;
  }

  /**
   * ���ݱ�������ֶ���Ϣ��ȡ��
   */
  public List getFieldList() {
    return this._field_list;
  }

  /**
   * ��Ӣ���ֶεĶ��չ�ϵ
   */
  /*
  public void setCEFieldMapping(Hashtable field_mapping) {
    this._ce_field_mapping = field_mapping;
  }
*/
  /**
   * ���ݱ�������ֶ���Ϣ��ȡ��
   */
 /* public Hashtable getCEFieldMapping() {
    return this._ce_field_mapping;
  }*/
 
  //public class 
  public class DDLParser{
	  //private TableMeta instance=new TableMeta();
	  //ע�ͱ�־
	  private static final String NOTE_FLAG = "--";

	  //��ʼ��־
	  private static final String TABLE_START = "CREATE TABLE";
	  //��ʼ��־
	  private static final String IF_NOT_EXISTS = "IF NOT EXISTS";

	  //Լ����־
	  private static final String TABLE_CONSTRAINT = "CONSTRAINT";

	  //������־
	  private static final String TABLE_PRIMARY_KEY = "PRIMARY KEY";
	  
	  //������ʼ��־
	  private static final String TABLE_CREATE_START = "(";

	  //����������־
	  private static final String TABLE_CREATE_END = ")";

	  //�ֶ�defaultֵ��־
	  private static final String DEFAULT_FLAG = "DEFAULT";

	  //�ֶ�NOT NULL��־
	  private static final String NOT_NULL_FLAG = "NOT NULL";

	  //�ֶ�����֮������з�
	  private static final String FIELD_SEPARATE = " ";

	  //�ֶν�����־
	  private static final String FIELD_END = ",";
	  
	  /**
	   * ��DDL�ļ����н���
	   * 
	   */
	  private void parseDDL(String ddl_file_path) {

	    try {
	      //����FileReader���󣬲�ʵ����Ϊfr
	      FileReader fr = new FileReader(ddl_file_path);

	      //����BufferedReader���󣬲�ʵ����Ϊbr
	      BufferedReader br = new BufferedReader(fr);

	      ArrayList fields = new ArrayList();
	      String line = null;
	      String line_upper = null;
	      int index = 0;

	      do {
	        line = br.readLine();      //���ļ���ȡһ���ַ���

	        if (line == null) break;

	        //�����ַ�ȫ��תΪ��д
	        line = line.trim();
	        line_upper = line.toUpperCase();

	        //ȡ�����ݱ�ı�ע��
	        if (line_upper.startsWith(NOTE_FLAG)) {
	        	_table_comment=line.replaceAll(NOTE_FLAG, "");
	        	}

	        //ȡ�����ݱ�ı���
	        if (line_upper.startsWith(TABLE_START)) {
	          String table_name = line_upper.replaceAll(TABLE_START, "");
	          if(table_name.indexOf(IF_NOT_EXISTS)!=-1){
	        	  table_name=table_name.replaceAll(IF_NOT_EXISTS,"");
	          }
	          table_name = table_name.trim();
	          index = table_name.indexOf(TABLE_CREATE_START);
	          if (index >= 0) {
	            table_name = table_name.substring(0, index - 1).trim();
	          }
	          
	          int t1=line.toUpperCase().indexOf(table_name);
	          
	          int t2=t1+table_name.length();
	          _table_name=line.substring(t1,t2);
	        }

	        //ȡ�����ݱ������
	        if (line_upper.indexOf(TABLE_PRIMARY_KEY)>-1) {
	          int index1 = line_upper.indexOf("(");
	          int index2 = line_upper.indexOf(")");
	          String strKeyFieldList=line.substring(index1 + 1, index2).trim();
	          _key_field_list=Arrays.asList(strKeyFieldList.split(","));	          
	        }

	        if (line_upper.startsWith(TABLE_CREATE_END)) {
	          break;
	        }

	        if (line_upper.indexOf(FIELD_END) >= 0  &&
	            !line_upper.startsWith(TABLE_CONSTRAINT)) {
	          fields.add(line);
	        }
	      } while (line != null);      //�ж϶�ȡ�����ַ����Ƿ�Ϊ��

	      //���ж����е��ֶν��н���,ȡ���ֶε��ֶ���,�ֶ�����,NOT NULL, defaultֵ��
	      Iterator field_items = fields.iterator();
	      ArrayList parsed_fields = new ArrayList();
	      while (field_items.hasNext()) {
	        line = (String)field_items.next();
	        parsed_fields.add(parseField(line));
	      }

	      //�����е��ֶ���Ϣ�洢������Ϣ��
	      _field_list=parsed_fields;

	      //����ȡ�õ�VO�Ƿ���Ч��ȷ
	      //TableMeta.testGottenVo(vo);

	      //�ر�BufferedReader����
	      br.close();

	      //�ر��ļ�
	      fr.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println(e.toString());
	    }
	    //return this;
	  }
	  
	  /**
	   * ���ֶ�����Ϣ�����ɾ�����ֶ���,NOT NULL, defaultֵ,ע�͵�
	   */
	  private FieldMeta parseField(String field) {
			int i_default = 0;
			int i_not_null = 0;
			int i_field_note = 0;
			int index = -1;

			field = field.trim();
			index = field.indexOf(FIELD_SEPARATE);

			//�ֶ�����ȡ��
			String fieldName = field.substring(0, index);

			field = field.substring(index).trim();

			i_default = field.toUpperCase().indexOf(DEFAULT_FLAG);
			boolean field_not_null = false;
			String field_default_value = null;
			String fieldType = null;
			if (i_default >= 0) {
				//�ֶ����͵�ȡ��
				fieldType = field.substring(0, i_default - 1);
				fieldType = fieldType.replaceAll(" ", "");
				//vo._field_type=temp;

				field = field.substring(i_default);

				i_not_null = field.toUpperCase().indexOf(NOT_NULL_FLAG);
				if (i_not_null >= 0) {
					fieldType = field.substring(0, i_not_null - 1).replaceAll(" ","");

					//NOT NULL���Ե�ȡ��
					field_not_null = true;
				} else {
					index = field.indexOf(FIELD_END);
					fieldType = field.substring(0, index - 1);
				}

				//defaultֵ��ȡ��
				index = field.toUpperCase().indexOf(DEFAULT_FLAG);
				if(field_default_value!=null)field_default_value = field_default_value.substring(
						DEFAULT_FLAG.length()).trim();
				if(field_default_value!=null)field_default_value = field_default_value.replaceAll("'", "");
			} else {
				i_not_null = field.toUpperCase().indexOf(NOT_NULL_FLAG);

				if (i_not_null >= 0) {
					//�ֶ����͵�ȡ��
					fieldType = field.substring(0, i_not_null - 1).replaceAll(" ","");

					//NOT NULL���Ե�ȡ��
					field_not_null = true;
				} else {
					index = field.lastIndexOf(FIELD_END);
					fieldType = field.substring(0, index);
				}
			}
			i_field_note = field.indexOf(NOTE_FLAG);
			String field_comment = null;
			if (i_field_note >= 0) {
				//�ֶ�ע�͵�ȡ��
				field_comment = field.substring(i_field_note + NOTE_FLAG.length())
						.trim();
			}

			return new FieldMeta(fieldName, fieldType, field_default_value,
					field_comment, field_not_null);
		}
  }
}
