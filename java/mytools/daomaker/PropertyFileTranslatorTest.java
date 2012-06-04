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
		assertNotNull("翻译器加载失败",translator);
		assertEquals("翻译表名失败","BUREAU",translator.translate("局"));
		assertEquals("翻译表名失败","JBOX_EQUIP",translator.translate("分线设备测试"));
		assertEquals("翻译字段名失败","BURID",translator.translate("局.局ID"));
		assertEquals("翻译字段名失败","OPERTIME",translator.translate("分线设备测试.操作时间"));
	}

}
