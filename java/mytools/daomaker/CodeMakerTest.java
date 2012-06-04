package mytools.daomaker;

import mytools.util.FileTools;
import junit.framework.TestCase;

public class CodeMakerTest extends TestCase {
	private static final String TEST_DIRECTORY_DDL = "D:\\temp\\dao\\pcb\\";
	private static final String TEST_DIRECTORY_DAO = "D:\\temp\\dao\\src\\";
	private static final String TEST_DIRECTORY_VO = "D:\\temp\\dao\\src\\";
	private static final String TEST_FILE = "d:\\temp\\dao\\pcb\\Candidate.sql";

	protected void setUp() throws Exception {
		super.setUp();
		FileTools.cleanFile(".java",TEST_DIRECTORY_DAO);
		FileTools.cleanFile(".java",TEST_DIRECTORY_VO);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	/*
	 * Test method for 'mytools.daomaker.CodeFactory.main(String[])'
	 */
	public void testMain() {
		String[] args=new String [1];
		args[0]=TEST_DIRECTORY_DDL;
		CodeMaker.main(args);
		String []daoFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_DAO+"pcbweb\\dao");
		String []voFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_VO+"pcbweb\\vo");
		String []ddlFileList=FileTools.getFileNames(".sql",TEST_DIRECTORY_DDL);
		assertEquals("���ɵ�dao�ļ���������",ddlFileList.length,daoFileList.length);
		assertEquals("���ɵ�vo�ļ���������",ddlFileList.length,voFileList.length);
		
		
	}
	public void testMainSingleFile() {
		String[] args=new String [1];		
		
		args[0]=TEST_FILE;
		CodeMaker.main(args);
		String []daoFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_DAO+"pcbweb\\dao");
		String []voFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_VO+"pcbweb\\vo");
		assertEquals("Ӧ������һ��dao�ļ�",1,daoFileList.length);
		assertEquals("Ӧ������һ��vo�ļ�",1,voFileList.length);
	}

}
