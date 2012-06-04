/*
 * VOTableInfo.java
 *
 * 机能：数据表文件基本信息存储类.
 * 类名：VOTableInfo
 *
 *   ver    变更日        公司     担当者    变更内容
 * ──────────────────────────────────
 *  V1.00  '04-04-21  　 (SURE)    成晓勇    初版
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
 * DDL数据文件的描述对象
 * 
 * 注意：描述中主键约束请使用一行表示，否则无法正确解析
 * @author zhangcheng
 *
 */
public class TableMeta {
  Logger logger=Logger.getLogger(TableMeta.class);	
  //表的注释
  private String _table_comment = "";

  //中文表名
  private String _table_name = "";
  
  
 //数据表的主键
  private List _key_field_list;

  //数据表的所有字段信息
  private List _field_list = null;

  //中英文字段的对应关系
  private static Translator translator = null;

  /**
   * 构造函数
   */
  public TableMeta(String ddl_file_path) {
	  loadDDL(ddl_file_path);	  
  }
  /**
   * 构造函数
   */
  public TableMeta(String ddl_file_path,Translator trans) {
	  loadDDL(ddl_file_path);
	  if(translator==null)translator=trans;
  }  
 
private void loadDDL(String ddl_file_path){
	  
	  new DDLParser().parseDDL(ddl_file_path);
  }

  /**
   * 表的注释的取得
   */
  public String getTableComment() {
    return this._table_comment;
  }

 
  /**
   * 中文表名的取得
   */
  public String getTableName() {
    return this._table_name;
  }

 
  /**
   * 英文表名的取得
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
   * 数据表的主键的取得
   */
 public List getKeyFieldList() {
    return this._key_field_list;
  }

  /**
   * 数据表的所有字段信息的取得
   */
  public List getFieldList() {
    return this._field_list;
  }

  /**
   * 中英文字段的对照关系
   */
  /*
  public void setCEFieldMapping(Hashtable field_mapping) {
    this._ce_field_mapping = field_mapping;
  }
*/
  /**
   * 数据表的所有字段信息的取得
   */
 /* public Hashtable getCEFieldMapping() {
    return this._ce_field_mapping;
  }*/
 
  //public class 
  public class DDLParser{
	  //private TableMeta instance=new TableMeta();
	  //注释标志
	  private static final String NOTE_FLAG = "--";

	  //表开始标志
	  private static final String TABLE_START = "CREATE TABLE";
	  //表开始标志
	  private static final String IF_NOT_EXISTS = "IF NOT EXISTS";

	  //约束标志
	  private static final String TABLE_CONSTRAINT = "CONSTRAINT";

	  //主键标志
	  private static final String TABLE_PRIMARY_KEY = "PRIMARY KEY";
	  
	  //表创建开始标志
	  private static final String TABLE_CREATE_START = "(";

	  //表创建结束标志
	  private static final String TABLE_CREATE_END = ")";

	  //字段default值标志
	  private static final String DEFAULT_FLAG = "DEFAULT";

	  //字段NOT NULL标志
	  private static final String NOT_NULL_FLAG = "NOT NULL";

	  //字段内容之间的区切符
	  private static final String FIELD_SEPARATE = " ";

	  //字段结束标志
	  private static final String FIELD_END = ",";
	  
	  /**
	   * 对DDL文件进行解析
	   * 
	   */
	  private void parseDDL(String ddl_file_path) {

	    try {
	      //建立FileReader对象，并实例化为fr
	      FileReader fr = new FileReader(ddl_file_path);

	      //建立BufferedReader对象，并实例化为br
	      BufferedReader br = new BufferedReader(fr);

	      ArrayList fields = new ArrayList();
	      String line = null;
	      String line_upper = null;
	      int index = 0;

	      do {
	        line = br.readLine();      //从文件读取一行字符串

	        if (line == null) break;

	        //将行字符全部转为大写
	        line = line.trim();
	        line_upper = line.toUpperCase();

	        //取得数据表的表注释
	        if (line_upper.startsWith(NOTE_FLAG)) {
	        	_table_comment=line.replaceAll(NOTE_FLAG, "");
	        	}

	        //取得数据表的表名
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

	        //取得数据表的主键
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
	      } while (line != null);      //判断读取到的字符串是否不为空

	      //逐行对所有的字段进行解析,取得字段的字段名,字段类型,NOT NULL, default值等
	      Iterator field_items = fields.iterator();
	      ArrayList parsed_fields = new ArrayList();
	      while (field_items.hasNext()) {
	        line = (String)field_items.next();
	        parsed_fields.add(parseField(line));
	      }

	      //将所有的字段信息存储到表信息中
	      _field_list=parsed_fields;

	      //测试取得的VO是否有效正确
	      //TableMeta.testGottenVo(vo);

	      //关闭BufferedReader对象
	      br.close();

	      //关闭文件
	      fr.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println(e.toString());
	    }
	    //return this;
	  }
	  
	  /**
	   * 将字段行信息解析成具体的字段名,NOT NULL, default值,注释等
	   */
	  private FieldMeta parseField(String field) {
			int i_default = 0;
			int i_not_null = 0;
			int i_field_note = 0;
			int index = -1;

			field = field.trim();
			index = field.indexOf(FIELD_SEPARATE);

			//字段名的取得
			String fieldName = field.substring(0, index);

			field = field.substring(index).trim();

			i_default = field.toUpperCase().indexOf(DEFAULT_FLAG);
			boolean field_not_null = false;
			String field_default_value = null;
			String fieldType = null;
			if (i_default >= 0) {
				//字段类型的取得
				fieldType = field.substring(0, i_default - 1);
				fieldType = fieldType.replaceAll(" ", "");
				//vo._field_type=temp;

				field = field.substring(i_default);

				i_not_null = field.toUpperCase().indexOf(NOT_NULL_FLAG);
				if (i_not_null >= 0) {
					fieldType = field.substring(0, i_not_null - 1).replaceAll(" ","");

					//NOT NULL属性的取得
					field_not_null = true;
				} else {
					index = field.indexOf(FIELD_END);
					fieldType = field.substring(0, index - 1);
				}

				//default值的取得
				index = field.toUpperCase().indexOf(DEFAULT_FLAG);
				if(field_default_value!=null)field_default_value = field_default_value.substring(
						DEFAULT_FLAG.length()).trim();
				if(field_default_value!=null)field_default_value = field_default_value.replaceAll("'", "");
			} else {
				i_not_null = field.toUpperCase().indexOf(NOT_NULL_FLAG);

				if (i_not_null >= 0) {
					//字段类型的取得
					fieldType = field.substring(0, i_not_null - 1).replaceAll(" ","");

					//NOT NULL属性的取得
					field_not_null = true;
				} else {
					index = field.lastIndexOf(FIELD_END);
					fieldType = field.substring(0, index);
				}
			}
			i_field_note = field.indexOf(NOTE_FLAG);
			String field_comment = null;
			if (i_field_note >= 0) {
				//字段注释的取得
				field_comment = field.substring(i_field_note + NOTE_FLAG.length())
						.trim();
			}

			return new FieldMeta(fieldName, fieldType, field_default_value,
					field_comment, field_not_null);
		}
  }
}
