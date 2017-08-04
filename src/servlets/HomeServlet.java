package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import util.DbProduct;


/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int filterByUserID = 0; 
		String nextURL = "/error.jsp";
		//get user out of session. If they don't exist then send them back to the login page.
		//kill the session while you're at it.
		HttpSession session = request.getSession();


		String action = request.getParameter("action");

		String searchtype = request.getParameter("search_param");

		String searchtext = request.getParameter("searchtext");

		//first... check that the action variable contains something
		//then the code below will determine if they clicked logout and kill the session
		//before sending the user back to the login page
		
		if(!(action==null)){
			if (request.getParameter("action").toString().equals("logout")){
				//Go back to login.jsp. 
				nextURL = "/login.jsp";
				session.invalidate();
				response.sendRedirect(request.getContextPath() + nextURL);
				return;//return here exits the method and prevents an error
			}
		}


		//get posts based on parameters; if no parameters then get all posts
		List<Product> products = null;
		products = DbProduct.getProducts();

		//add posts to session
		session.setAttribute("products", products);
		
		nextURL = "/home.jsp";
		//redirect to next page as indicated by the value of the nextURL variable
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
