package mytools.srtconvert;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mytools.srtconvert.Srt2Html;

import junit.framework.TestCase;

public class Srt2HtmlTest extends TestCase {
	
	private static final String TEST_PATH = ".";
	//private static final String TEST_PATH = ".";
	private static final String TEST_FILENAME_EN = "Desperate Housewives - S01E09 - Suspicious Minds.en.srt";
	private static final String TEST_FILENAME_CN = "Desperate Housewives - S01E09 - Suspicious Minds.chs.srt";
	
	Srt2Html tester=new Srt2Html();
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		mytools.util.FileTools.cleanFile(".htm", TEST_PATH);
		mytools.util.FileTools.cleanFile(".txt", TEST_PATH);
		
	}
	public void testCreateHtml() throws FileNotFoundException{		
		tester.createHtml(TEST_PATH+TEST_FILENAME_CN,TEST_PATH+TEST_FILENAME_EN);
		String movieName=TEST_FILENAME_CN.substring(0,TEST_FILENAME_CN.length()-8);		
		File file=new File(TEST_PATH+movieName+".htm");
		
		assertTrue(file.exists());
		
		
	}
	public void testParseSrt() throws FileNotFoundException{
		File testFile=new File(TEST_PATH+TEST_FILENAME_EN);
		Map result=tester.parseSrt(testFile);
		assertTrue((result.size()>0));
		
	}
	public void testMultiTransferProcess(){		
		tester.multiSrtProcess(TEST_PATH,"HTML");
		File directory=new File(TEST_PATH);
		String []cn_movie_list=directory.list(new FilenameFilter(){

			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.endsWith(".chs.srt"))return true;
				return false;
			}
			
		});
		String []en_movie_list=directory.list(new FilenameFilter(){			
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.endsWith(".en.srt"))return true;
				return false;
			}
			
		});
		String []htm_file_list=directory.list(new FilenameFilter(){

			public boolean accept(File dir, String name) {
				if(name.endsWith(".htm"))return true;
				return false;
			}
			
		});
		assertTrue("字幕文件个数与生成的htm文件个数不相等！",(cn_movie_list.length==htm_file_list.length)||(en_movie_list.length == htm_file_list.length));
	}
	public void testCreateText(){		
		tester.createText(TEST_PATH+TEST_FILENAME_CN);
		File file=new File(TEST_PATH+TEST_FILENAME_CN.substring(0,TEST_FILENAME_CN.length()-4)+".txt");
		assertTrue(file.exists());
	}
	
}
