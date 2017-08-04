package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DbUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Yuseremail = request. getParameter ("email");
		String Yuserpassword = request.getParameter("password");
		String nextPage = "home.jsp";
		HttpSession session = request.getSession();

		if (DbUser.isValidUser(Yuseremail,Yuserpassword)){
			//add the valid user to the session
			session.setAttribute("user", DbUser.getUserByEmail(Yuseremail));
			nextPage = "/Home";
		}else{
			//probably not necessary but you can clear all session variables just to be sure nobody can access them 
			session.invalidate();
			//they put in the wrong password or don't exist in the database
			nextPage = "/login.jsp";
		}

		//Your work here is done. Redirect to next page as indicated by the value of the nextURL variable
		response.sendRedirect(request.getContextPath() + nextPage);

	}


}

