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
		assertEquals("生成的dao文件数量不对",ddlFileList.length,daoFileList.length);
		assertEquals("生成的vo文件数量不对",ddlFileList.length,voFileList.length);
		
		
	}
	public void testMainSingleFile() {
		String[] args=new String [1];		
		
		args[0]=TEST_FILE;
		CodeMaker.main(args);
		String []daoFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_DAO+"pcbweb\\dao");
		String []voFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_VO+"pcbweb\\vo");
		assertEquals("应该生成一个dao文件",1,daoFileList.length);
		assertEquals("应该生成一个vo文件",1,voFileList.length);
	}

}
