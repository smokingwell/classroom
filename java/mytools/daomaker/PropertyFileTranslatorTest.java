package mytools.daomaker;

import junit.framework.TestCase;

public class PropertyFileTranslatorTest extends TestCase {

	private static final String FILE_TEST = "d:\\temp\\dao\\pcb\\TranslationList.properties";

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Test method for 'mytools.daomaker.PropertyFileTranslator.PropertyFileTranslator(String)'
	 */
	public void testPropertyFileTranslator() {
		Translator translator=new PropertyFileC2ETranslator(FILE_TEST);
		assertNotNull("����������ʧ��",translator);
		assertEquals("�������ʧ��","BUREAU",translator.translate("��"));
		assertEquals("�������ʧ��","JBOX_EQUIP",translator.translate("�����豸����"));
		assertEquals("�����ֶ���ʧ��","BURID",translator.translate("��.��ID"));
		assertEquals("�����ֶ���ʧ��","OPERTIME",translator.translate("�����豸����.����ʱ��"));
	}

}
