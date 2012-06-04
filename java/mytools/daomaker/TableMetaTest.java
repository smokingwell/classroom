package mytools.daomaker;

import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

public class TableMetaTest extends TestCase {
	private static final String TEST_FILE = "d:\\temp\\dao\\pcb\\Candidate.sql";
	private static final String TEST_FILE_CN = "d:\\temp\\dao\\pcb\\BUREAU.sql";

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Test method for 'mytools.daomaker.TableMeta.TableMeta(String)'
	 */
	public void testTableMetaString() {
		TableMeta t=new TableMeta(TEST_FILE);
		assertNotNull("TableMeta取表名为null"+t.getTableName());
		assertEquals("TableMeta取表名不正确","Candidate",t.getTableName());
		
		List fieldList=t.getFieldList();
		assertEquals("字段列表长度不正确",15,fieldList.size());
		FieldMeta theFirstField=(FieldMeta)fieldList.get(0);
		//assertNotNull()
		assertEquals("第一个字段名称不正确","CANDIDATE_PK",theFirstField.get_field_name());
		assertEquals("第一个字段类型不正确","varchar(20)",theFirstField.get_field_type());
		assertEquals("第一个字段是否为默认值不正确",true,theFirstField.is_field_not_null());
		assertEquals("第一个字段默认值不正确",null,theFirstField.get_field_default_value());
		
		assertEquals("主键字段长度不正确",1,t.getKeyFieldList().size());
		assertEquals("主键字段不正确","CANDIDATE_PK",t.getKeyFieldList().get(0).toString());
		
		assertNotNull("表注释字段为null"+t.getTableComment());
		
		

	}

	/*
	 * Test method for 'mytools.daomaker.TableMeta.TableMeta(String, Translator)'
	 */
	public void testTableMetaStringTranslator() {
		Translator trans=new Translator(){

			public String translate(String name) {
				// TODO Auto-generated method stub
				HashMap m=new HashMap();
				m.put("局","BUREAU");
				m.put("局.局ID","BUREAU_ID");
				return m.get(name).toString();
			}
			
		};
		TableMeta t=new TableMeta(TEST_FILE_CN,trans);
		assertNotNull("TableMeta取表名为null"+t.getTableName());
		assertEquals("TableMeta取表名不正确","局",t.getTableName());
		assertEquals("TableMeta取翻译后的表名不正确","BUREAU",t.translate(t.getTableName()));
		
		List fieldList=t.getFieldList();
		assertEquals("字段列表长度不正确",5,fieldList.size());
		FieldMeta theFirstField=(FieldMeta)fieldList.get(0);
		//assertNotNull()
		assertEquals("第一个字段名称不正确","局ID",theFirstField.get_field_name());
		assertEquals("第一个字段名称不正确","BUREAU_ID",t.translate(theFirstField.get_field_name()));
		assertEquals("第一个字段类型不正确","NUMBER(6)",theFirstField.get_field_type());
		assertEquals("第一个字段是否为默认值不正确",true,theFirstField.is_field_not_null());
		assertEquals("第一个字段默认值不正确",null,theFirstField.get_field_default_value());
		
		assertEquals("主键字段长度不正确",1,t.getKeyFieldList().size());
		assertEquals("主键字段不正确","局ID",t.getKeyFieldList().get(0).toString());
		
		assertNotNull("表注释字段为null"+t.getTableComment());	
	}

}
