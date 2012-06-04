package mytools.daomaker;

import junit.framework.TestCase;

public class MysqlDAOCodeWorkerTest extends TestCase {
	private static final String OUTPUT_DIRECTORY = "d:\\temp\\dao\\src\\";
	private static final String FILE_TEST = "d:\\temp\\dao\\pcb\\Candidate.sql";

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Test method for 'mytools.daomaker.DefaultDAOCodeWorker.createUpdateByFieldMethod(String)'
	 */
	public void testCreate() {
		IWorker worker=new MysqlDAOCodeWorker();
		//worker.
		worker.create(FILE_TEST,OUTPUT_DIRECTORY);
	
		String[] fileNames=mytools.util.FileTools.getFileNames(".java",OUTPUT_DIRECTORY);
		assertNotNull("���ɵ��ļ����鲻�÷���null",fileNames);
		assertEquals("���ɵ��ļ�������Ŀ����",1,fileNames.length);
	}

}
