package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession mysession = request.getSession();
       if (request.getParameter("function") != null){
            if (request.getParameter("function").equals("logout")){
            request.setAttribute("message", "Logged Out");
            
            mysession.removeAttribute("userObject");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        }
       
       
       
       if (mysession.getAttribute("userObject") != null) {
           String userName = (String) mysession.getAttribute("userName");
           request.setAttribute("username", userName);
                      getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }  
       
       
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("action") != null && request.getParameter("action").equals("register")){
            String username = request.getParameter("uname");
            if (username != null && !username.equals("")) {
                
            }
        }
        
    }
}
