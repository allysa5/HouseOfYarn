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

		String typeoflist = (String) request.getParameter("list");
		int aP = Integer.parseInt(request.getParameter("productname"));
		Product newCartItem = DbProduct.getProduct(aP);
		String nextURL = "/error.jsp";
		if(request.getParameter("Quantity").isEmpty()){
			request.setAttribute("AddCart", "Please enter the quantity of the item you wish to purchase!");
			nextURL = "/HomeServlet";
			//System.out.println(request.getAttribute("AddCart"));
			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
			return;
		}
		
		

		//int userid = Integer.parseInt(request.getParameter("userid"));
		HttpSession session = request.getSession();
		if (session.getAttribute("yuser")==null){
			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
			nextURL = "/login.jsp";
			session.invalidate();
			response.sendRedirect(request.getContextPath() + nextURL);
		    return;//return prevents an error
		}
		
		Yuser thisUser = (Yuser) session.getAttribute("yuser");
		
		Yuseritem toAdd = new Yuseritem();
		toAdd.setList(typeoflist);
		toAdd.setProduct(newCartItem);
		toAdd.setQuantity(Integer.parseInt(request.getParameter("Quantity")));
		toAdd.setPrice(newCartItem.getPrice());

//		Date now = new Date();
//		toAdd.setPurchasedate(now);
//		need to allow in form the quantity. So form vs GET 
		toAdd.setYuser(thisUser);
		
		
//		if(DbItems.getItem())
		
		DbItems.insert(toAdd);
		request.setAttribute("AddCart", newCartItem.getProductname() + " added to cart");
		nextURL = "/HomeServlet";
		//System.out.println(request.getAttribute("AddCart"));
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
