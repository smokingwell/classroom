package junit.mock;

import java.io.PrintWriter;
import java.io.StringWriter;

import junit.framework.TestCase;

public class TestServletByMockCreator extends TestCase {
	 public void testSimpleAdditionUsingMockCreator() throws Exception {

		    final MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

		    final MockHttpServletResponse mockHttpServletResponse =

		            new MockHttpServletResponse();



		   //mockHttpServletRequest.startBlock();
		    mockHttpServletRequest.expectGetParameter("a").returns("3");

		    mockHttpServletRequest.expectGetParameter("b").returns("4");
		    //mockHttpServletRequest.expectGetParameter("b", "4");


		    //mockHttpServletRequest.endBlock();



		    final StringWriter output = new StringWriter();

		    final PrintWriter contentWriter = new PrintWriter(output); 



		    //mockHttpServletRequest.expectzeroOrMoreSet
		    mockHttpServletResponse.expectSetContentType("text/html"); 

		    mockHttpServletResponse.expectGetWriter().returns(contentWriter);



		    SimpleCalcServlet aServlet = new SimpleCalcServlet(); 

		    aServlet.doGet(mockHttpServletRequest, mockHttpServletResponse); 



		    //mockHttpServletRequest.verify(); 

		    //mockHttpServletResponse.verify(); 

		    assertEquals("Output should be an addition", "Result = 7", output.toString()); 

		}

}
