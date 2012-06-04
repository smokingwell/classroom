package mytools.daomaker;

import util.FileTools;
import junit.framework.TestCase;

public class AutoCreatorTest extends TestCase {
	
	private static final String TEST_DIRECTORY_DDL = "D:\\temp\\dao\\pcb";
	private static final String TEST_DIRECTORY_DAO = "D:\\temp\\dao\\src\\dao";
	private static final String TEST_DIRECTORY_VO = "D:\\temp\\dao\\src\\vo";
	private static final String TEST_FILE = "d:\\temp\\dao\\pcb\\Candidate.sql";

	protected void setUp() throws Exception {
		super.setUp();
		FileTools.cleanFile(".java",TEST_DIRECTORY_DAO);
		FileTools.cleanFile(".java",TEST_DIRECTORY_VO);
	}

	protected void tearDown() throws Exception {
		
		super.tearDown();
		//keep the file genarated
	}

	/*
	 * Test method for 'mytools.daomaker.AutoCreator.create()'
	 */
	public void testCreate() {

	}

	/*
	 * Test method for 'mytools.daomaker.AutoCreator.main(String[])'
	 */
	public void testMain() {
	String[] args=new String [1];
	args[0]=TEST_DIRECTORY_DDL;
	AutoCreator.main(args);
	String []daoFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_DAO);
	String []voFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_VO);
	String []ddlFileList=FileTools.getFileNames(".sql",TEST_DIRECTORY_DDL);
	assertEquals("生成的dao文件数量不对",ddlFileList.length,daoFileList.length);
	assertEquals("生成的vo文件数量不对",ddlFileList.length,voFileList.length);
	
	args[0]=TEST_FILE;
	AutoCreator.main(args);
	daoFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_DAO);
	voFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_VO);
	assertEquals("应该生成一个dao文件",1,daoFileList.length);
	assertEquals("应该生成一个vo文件",1,voFileList.length);
	
	}

}
