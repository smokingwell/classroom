package mytools.daomaker;

import mytools.util.StringTools;
import junit.framework.TestCase;

public class BaseDAOWorkerTest extends TestCase {
	private static final String OUTPUT_DIRECTORY = "d:\\temp\\dao\\src\\";
	private static final String FILE_TEST = "d:\\temp\\dao\\pcb\\Candidate.sql";

	IWorker worker=null;
	protected void setUp() throws Exception {
		worker=new BaseDAOWorker(){

			public String createUpdateByFieldMethod(String updateByField_name) {
				// TODO Auto-generated method stub
				return "ignore";
			}

			public String createQueryMethod(String query_name) {
				// TODO Auto-generated method stub
				return "ignore";
			}

			public String createQueryExactMethod(String queryExact_name) {
				// TODO Auto-generated method stub
				return "ignore";
			}

			public String createDeleteMethod(String delete_name) {
				// TODO Auto-generated method stub
				return "ignore";
			}

			public String createUpdateMethod(String update_name) {
				// TODO Auto-generated method stub
				return "ignore";
			}

			public String createInsertMethod(String insert_name) {
				// TODO Auto-generated method stub
				return "ignore";
			}

			public String createInsertPKMethod(String insert_pk_name) {
				// TODO Auto-generated method stub
				return "ignore";
			}

			public String getJavaType(String orcale_type) {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
		super.setUp();
	}

	/*
	 * Test method for 'mytools.daomaker.BaseDAOWorker.create(String, String)'
	 */
	public void testCreate() {
		worker.create(FILE_TEST,OUTPUT_DIRECTORY);
		String daoCreatedPath=OUTPUT_DIRECTORY;
		daoCreatedPath+=StringTools.replaceAll(((BaseDAOWorker)worker).getDAOPackageName(),".","\\");
		daoCreatedPath+="\\";
		//worker.
		String[] fileNames=mytools.util.FileTools.getFileNames(".java",OUTPUT_DIRECTORY);
		assertNotNull("生成的文件数组不该返回null",fileNames);
		assertEquals("生成的文件数组数目不对",1,fileNames.length);
	}


}
