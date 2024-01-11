

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
  response.setContentType("text/html");  
  PrintWriter out=response.getWriter();  
    
  HttpSession session=request.getSession(false);
  
  out.println("<!DOCTYPE html>");
  out.println("<html>");
  out.println("<head>");
  out.println("<meta charset='UTF-8'>");
  out.println("<title>Profile Page</title>");
  out.println("</head>");
  out.println("<body style='text-align:center; background-color:silver'>");
  out.println("<div style='width:600px; margin: 50px auto; background-color: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);'>");

  if (session != null) {
      String name = (String) session.getAttribute("name");
      out.print("<h1>Hello! " + name + " Welcome to Profile!</h1>");

      // Swapping the logic for displaying images
      if (isMale(name)) {
          out.println("<img src='" + request.getContextPath() + "/images/boy.jpg' alt='Boy Image' style='width: 500px; height: 400px;'>");
      } else if (isFemale(name)) {
          out.println("<img src='" + request.getContextPath() + "/images/girl.jpeg' alt='Girl Image' style='width: 500px; height: 400px;'>");
      }

      // Adding a button for logout with a green background color
      out.println("<form action='LogoutServlet'>");
      out.println("<input type='submit' value='LOGOUT' style='background-color: #4caf50; color: white; border: none; padding: 10px; border-radius: 5px; cursor: pointer;'>");
      out.println("</form>");
  } else {
      out.print("<h1>Please login first</h1>");
      request.getRequestDispatcher("login.html").include(request, response);
  }

  out.println("</div>");
  out.println("</body>");
  out.println("</html>");
}

private boolean isMale(String name) {
  // Check if the name ends with certain patterns typically associated with male names
  return name.toLowerCase().endsWith("a") || name.toLowerCase().endsWith("i") ||
         name.toLowerCase().endsWith("ee") || name.toLowerCase().endsWith("ika");
}

private boolean isFemale(String name) {
  // Check if the name ends with certain patterns typically associated with female names
  return !isMale(name);
}
}