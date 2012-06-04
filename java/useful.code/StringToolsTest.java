package mytools.util;

import java.io.File;

import junit.framework.TestCase;

public class StringToolsTest extends TestCase {

	/*
	 * Test method for 'mytools.util.StringTools.getSafeDirecotyPath(String)'
	 */
	public void testGetSafeWindowsDirecotyPath() {
		
		String safeDirecotyPath = StringTools.getSafeWindowsDirecotyPath("d:\\temp\\abc");
		File f=new File(safeDirecotyPath);
		assertTrue(f.isDirectory());
		assertEquals("","d:\\temp\\abc\\",safeDirecotyPath);
		
		safeDirecotyPath="d:/temp";
		f=new File(safeDirecotyPath);
		assertTrue(f.isDirectory());
		assertTrue(StringTools.getSafeWindowsDirecotyPath(safeDirecotyPath).endsWith("\\"));

		f=new File(safeDirecotyPath);
		assertTrue(f.isDirectory());
		safeDirecotyPath="d:/temp/c";
		assertTrue(StringTools.getSafeWindowsDirecotyPath(safeDirecotyPath).endsWith("\\"));
		
	}

}
