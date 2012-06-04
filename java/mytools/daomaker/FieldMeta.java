/**
 * 
 */
package mytools.daomaker;


public class FieldMeta {

	// 字段注释
	String _field_comment = "";

	// 中文字段名
	String _field_name = "";

	/*
	 * //英文字段名 private String _en_field_name = "";
	 */
	// 字段类型
	String _field_type = "";

	// 字段是否是NOT NULL
	boolean _field_not_null = false;

	// 字段default值
	String _field_default_value = "";


	public String get_field_comment() {
		return _field_comment;
	}

	public String get_field_default_value() {
		return _field_default_value;
	}

	public String get_field_name() {
		return _field_name;
	}

	public boolean is_field_not_null() {
		return _field_not_null;
	}

	public String get_field_type() {
		return _field_type;
	}
	

	public FieldMeta(String fieldName, String fieldType, String default_value,String fieldComment,boolean isNotNull) {
		this._field_name=fieldName;
		this._field_type=fieldType;
		this._field_default_value=default_value;
		this._field_not_null=isNotNull;
		this._field_comment=fieldComment;

	}
	public FieldMeta(String fieldName, String fieldType) {
		this._field_name=fieldName;
		this._field_type=fieldType;	
		
	}

}