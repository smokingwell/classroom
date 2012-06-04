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
	assertEquals("���ɵ�dao�ļ���������",ddlFileList.length,daoFileList.length);
	assertEquals("���ɵ�vo�ļ���������",ddlFileList.length,voFileList.length);
	
	args[0]=TEST_FILE;
	AutoCreator.main(args);
	daoFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_DAO);
	voFileList=FileTools.getFileNames(".java",TEST_DIRECTORY_VO);
	assertEquals("Ӧ������һ��dao�ļ�",1,daoFileList.length);
	assertEquals("Ӧ������һ��vo�ļ�",1,voFileList.length);
	
	}

}
