import junit.framework.TestCase;

/*
 * Created on 2006-2-8
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author ryan
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MotoQuestionTest extends TestCase {

	/**
	 * Constructor for MotoQuestionTest.
	 * @param arg0
	 */
	public MotoQuestionTest(String arg0) {
		super(arg0);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testMain() {
		String[]test4={"123","-123"};
		MotoQuestion.main(test4);
		
		String[]test1={"-123","-123"};
		MotoQuestion.main(test1);

				
		}

	public void testCaculator() {
		MotoQuestion m=new MotoQuestion();		
		assertEquals("123+123=246","246",m.caculate("123","123",true));
		assertEquals("123+1230=1353","1353",m.caculate("1230","123",true));
		assertEquals("9+1111=1120","1120",m.caculate("1111","9",true));
		assertEquals("1+9999=10000","10000",m.caculate("9999","1",true));
		
		assertEquals("9999-1=9998","9998",m.caculate("9999","1",false));
		assertEquals("99999-99999=0","0",m.caculate("9999","9999",false));
		assertEquals("123-123=0","0",m.caculate("123","123",false));
		assertEquals("10000-1=9999","9999",m.caculate("10000","1",false));
		
	}
	
	
}
