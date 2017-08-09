package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Yuseritem;
import model.Yuser;
import util.DbItems;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextURL = "/login.jsp";

		HttpSession session = request.getSession();



		if (session.getAttribute("yuser")==null){
			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
			nextURL = "/login.jsp";
			response.sendRedirect(request.getContextPath() + nextURL);
			return;//return prevents an error; Don't believe me? Take it out.
		}else{


			String searchtype = request.getParameter("search_param");
			String searchtext = request.getParameter("searchtext");
			if(searchtype != null && searchtext != null){
				if(searchtype.equals("purchase")){
					System.out.println(searchtext);
					nextURL = "/cart.jsp";
					Yuser logged = (Yuser) session.getAttribute("yuser");
					List<Yuseritem > history = DbItems.searchPurchased( logged.getYuserid() ,searchtext);
					request.setAttribute("cartitem", history);
					getServletContext().getRequestDispatcher(nextURL).forward(request,response);
					return;
				}
			}



			nextURL = "/cart.jsp";
			Yuser u = (Yuser) session.getAttribute("yuser");

			//	System.out.println(sam.getYuserId());


			request.setAttribute("cartitem", DbItems.getCartitems(u.getYuserid()));



			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
