package junit.mock;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class SimpleCalcServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException
    {
        Integer a = Integer.decode(request.getParameter("a"));
        Integer b = Integer.decode(request.getParameter("b"));
 
        int result = a.intValue() + b.intValue();
        response.setContentType("text/html");
 
        PrintWriter out = response.getWriter();
        out.print("Result = " + result);
        out.flush();
    }
}