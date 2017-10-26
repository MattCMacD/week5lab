package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        if (request.getParameter("action") != null) {
            if (request.getParameter("action").equals("logout")) {
                request.setAttribute("message", "Logged Out");

                mysession.removeAttribute("userObject");
                mysession.removeAttribute("array");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        }

        if (mysession.getAttribute("userObject") != null) {
            if (mysession.getAttribute("array") == null) {
                ArrayList<String> listitems = new <String> ArrayList();
                mysession.setAttribute("array", listitems);
                request.setAttribute("items", listitems);
            } else {
                ArrayList listitems = (ArrayList) mysession.getAttribute("array");
                request.setAttribute("items", listitems);
            }
            String userName = (String) mysession.getAttribute("userObject");
            request.setAttribute("username", userName);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("action") != null && request.getParameter("action").equals("register")) {
            String username = request.getParameter("uname");
            if (username != null && !username.equals("")) {
                HttpSession mysession = request.getSession();
                mysession.setAttribute("userObject", username);
                
                response.sendRedirect("ShoppingList");
            } else {
                request.setAttribute("message", "Please enter a name to use");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        } else if (request.getParameter("action") != null && request.getParameter("action").equals("add")) {
            String newitem = (String) request.getParameter("additem");
            if (newitem != null && !newitem.equals("")) {

                HttpSession mysession = request.getSession();
                ArrayList <String> itemList = (ArrayList<String>) mysession.getAttribute("array");
                itemList.add(newitem);
                mysession.setAttribute("array", itemList);
                
                response.sendRedirect("ShoppingList");
            }
        }

        else if (request.getParameter("action") != null && request.getParameter("action").equals("delete")) {
            String deletethis = (String) request.getParameter("delete");
           

                HttpSession mysession = request.getSession();
                ArrayList <String> itemList = (ArrayList<String>) mysession.getAttribute("array");
                
                for (int i = 0; i<itemList.size();i++){
                if(deletethis.equals(itemList.get(i))){
                    itemList.remove(i);
                    i--;
                }
                
                }
                mysession.setAttribute("array", itemList);
                
                response.sendRedirect("ShoppingList");
        }
        
    }
}
