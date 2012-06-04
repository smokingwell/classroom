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
		assertNotNull("TableMetaȡ����Ϊnull"+t.getTableName());
		assertEquals("TableMetaȡ��������ȷ","Candidate",t.getTableName());
		
		List fieldList=t.getFieldList();
		assertEquals("�ֶ��б��Ȳ���ȷ",15,fieldList.size());
		FieldMeta theFirstField=(FieldMeta)fieldList.get(0);
		//assertNotNull()
		assertEquals("��һ���ֶ����Ʋ���ȷ","CANDIDATE_PK",theFirstField.get_field_name());
		assertEquals("��һ���ֶ����Ͳ���ȷ","varchar(20)",theFirstField.get_field_type());
		assertEquals("��һ���ֶ��Ƿ�ΪĬ��ֵ����ȷ",true,theFirstField.is_field_not_null());
		assertEquals("��һ���ֶ�Ĭ��ֵ����ȷ",null,theFirstField.get_field_default_value());
		
		assertEquals("�����ֶγ��Ȳ���ȷ",1,t.getKeyFieldList().size());
		assertEquals("�����ֶβ���ȷ","CANDIDATE_PK",t.getKeyFieldList().get(0).toString());
		
		assertNotNull("��ע���ֶ�Ϊnull"+t.getTableComment());
		
		

	}

	/*
	 * Test method for 'mytools.daomaker.TableMeta.TableMeta(String, Translator)'
	 */
	public void testTableMetaStringTranslator() {
		Translator trans=new Translator(){

			public String translate(String name) {
				// TODO Auto-generated method stub
				HashMap m=new HashMap();
				m.put("��","BUREAU");
				m.put("��.��ID","BUREAU_ID");
				return m.get(name).toString();
			}
			
		};
		TableMeta t=new TableMeta(TEST_FILE_CN,trans);
		assertNotNull("TableMetaȡ����Ϊnull"+t.getTableName());
		assertEquals("TableMetaȡ��������ȷ","��",t.getTableName());
		assertEquals("TableMetaȡ�����ı�������ȷ","BUREAU",t.translate(t.getTableName()));
		
		List fieldList=t.getFieldList();
		assertEquals("�ֶ��б��Ȳ���ȷ",5,fieldList.size());
		FieldMeta theFirstField=(FieldMeta)fieldList.get(0);
		//assertNotNull()
		assertEquals("��һ���ֶ����Ʋ���ȷ","��ID",theFirstField.get_field_name());
		assertEquals("��һ���ֶ����Ʋ���ȷ","BUREAU_ID",t.translate(theFirstField.get_field_name()));
		assertEquals("��һ���ֶ����Ͳ���ȷ","NUMBER(6)",theFirstField.get_field_type());
		assertEquals("��һ���ֶ��Ƿ�ΪĬ��ֵ����ȷ",true,theFirstField.is_field_not_null());
		assertEquals("��һ���ֶ�Ĭ��ֵ����ȷ",null,theFirstField.get_field_default_value());
		
		assertEquals("�����ֶγ��Ȳ���ȷ",1,t.getKeyFieldList().size());
		assertEquals("�����ֶβ���ȷ","��ID",t.getKeyFieldList().get(0).toString());
		
		assertNotNull("��ע���ֶ�Ϊnull"+t.getTableComment());	
	}

}
