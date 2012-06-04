package junit.mock;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

import com.mockobjects.dynamic.Mock;
import com.mockobjects.dynamic.OrderedMock;

public class TestServletByMockObject extends TestCase {
	public void testSimpleAdditionUsingDynaMock() throws ServletException, IOException { 
	     final Mock mockHttpServletRequest = new Mock(HttpServletRequest.class); 
	     final Mock mockHttpServletResponse = new OrderedMock(HttpServletResponse.class,
	             "Response with non-default name"); 

	    mockHttpServletRequest.expectAndReturn("getParameter", "b", "4"); 
	     mockHttpServletRequest.expectAndReturn("getParameter", "a", "3"); 

	     final StringWriter output = new StringWriter(); 
	     final PrintWriter contentWriter = new PrintWriter(output); 

	     mockHttpServletResponse.expect("setContentType", "text/html"); 
	     mockHttpServletResponse.expectAndReturn("getWriter", contentWriter); 

	     SimpleCalcServlet aServlet = new SimpleCalcServlet(); 
	     aServlet.doGet((HttpServletRequest) mockHttpServletRequest.proxy(),  
	                    (HttpServletResponse) mockHttpServletResponse.proxy()); 

	     //mockHttpServletRequest.verify(); 
	     //mockHttpServletResponse.verify(); 
	     assertEquals("Output should be an addition", "Result = 7", output.toString()); 
	 } 
}
