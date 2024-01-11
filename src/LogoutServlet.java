

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
            
            
          HttpSession session=request.getSession();  
          session.invalidate();  
            
          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("<meta charset='ISO-8859-1'>");
          out.println("<title>Login Success</title>");
          out.println("</head>");
          out.println("<body style='text-align:center; background-color:silver'>");
          out.println("<div style='width: 500px; margin: 50px auto; background-color: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);'>");
          out.println("<h1>You are successfully logged out!</h1>");
          out.println("</div>");
          out.println("</body>");
          out.println("</html>");
     

		
		
		
		
	}

}
