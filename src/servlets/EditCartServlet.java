package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.Yuseritem;
import model.Yuser;
import util.DbItems;
import util.DbProduct;

/**
 * Servlet implementation class EditCartServlet
 */
@WebServlet("/EditCartServlet")
public class EditCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		String nextURL ;

		if (session.getAttribute("user") ==null){
			nextURL = "/login.jsp";
			response.sendRedirect(request.getContextPath() + nextURL);
			return;
		}

		Yuser u = (Yuser) session.getAttribute("user");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		//Integer count = Integer.parseInt(request.getParameter("count"));
		//System.out.println("reaches");
		Float price = Float.parseFloat(request.getParameter("price"));
		String url = request.getParameter("url");

		Product prod = new Product();
		prod.setProductname(name);
		prod.setProductdesc(description);
		prod.setPrice(price);
		prod.setImage(url);

		DbProduct.insert(prod);

		response.sendRedirect(request.getContextPath());

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
