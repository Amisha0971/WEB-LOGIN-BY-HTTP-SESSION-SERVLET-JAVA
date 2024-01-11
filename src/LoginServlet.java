

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		          
		        String name=request.getParameter("name");  
		        String password=request.getParameter("password");  
		          
		        if(password.equals("admin123")){  
		        	 HttpSession session=request.getSession();  
				        session.setAttribute("name",name);  
				        
		        	// Printing data within a centered container with a green button
		            out.println("<!DOCTYPE html>");
		            out.println("<html>");
		            out.println("<head>");
		            out.println("<meta charset='ISO-8859-1'>");
		            out.println("<title>Login Success</title>");
		            out.println("</head>");
		            out.println("<body style='text-align:center; background-color:silver'>");
		            out.println("<div style='width: 400px; margin: 50px auto; background-color: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);'>");
		            out.println("<h1>Welcome! " + name + "</h1>");
		            out.println("<form action='ProfileServlet'>");
		            out.println("<input type='submit' value='YOUR PROFILE' style='background-color: #4caf50; color: white; border: none; padding: 10px; border-radius: 5px; cursor: pointer;'>");
		            out.println("</form>");
		            out.println("</div>");
		            out.println("</body>");
		            out.println("</html>");
		       
		        }  
		        else{  
		            out.print("Sorry, username or password error!");  
		            request.getRequestDispatcher("login.html").include(request, response);  
		        }  

	
	
	}

}
