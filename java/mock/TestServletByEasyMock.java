package junit.mock;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

import org.easymock.MockControl;

public class TestServletByEasyMock extends TestCase {
	public void testSimpleAdditionUsingEasyMock() throws Exception {

		 MockControl control1 = MockControl.createControl(HttpServletRequest.class);

		 HttpServletRequest mockHttpServletRequest =

		         (HttpServletRequest)control1.getMock();

		 MockControl control2 = MockControl.createStrictControl(HttpServletResponse.class);

		 HttpServletResponse mockHttpServletResponse =

		         (HttpServletResponse)control2.getMock();



		 mockHttpServletRequest.getParameter("b");

		 control1.setReturnValue("4", 1);

		 mockHttpServletRequest.getParameter("a");

		 control1.setReturnValue("3", 1);



		 final StringWriter output = new StringWriter();

		 final PrintWriter contentWriter = new PrintWriter(output); 



		 mockHttpServletResponse.setContentType("text/html");

		 control2.setVoidCallable(1); 

		 mockHttpServletResponse.getWriter();

		 control2.setReturnValue(contentWriter, 1);



		 control1.replay();// 表示方法训练结束		 

		 control2.replay();



		 SimpleCalcServlet aServlet = new SimpleCalcServlet(); 

		 aServlet.doGet(mockHttpServletRequest, mockHttpServletResponse); 



		 //control1.verify(); 

		 //control2.verify(); 

		 assertEquals("Output should be an addition", "Result = 7", output.toString()); 

		 }

}
