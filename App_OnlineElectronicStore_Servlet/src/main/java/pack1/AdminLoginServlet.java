package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AdminBean abean = new AdminLoginDAO().checkAdminLogin(req.getParameter("auname"), req.getParameter("apwd"));
		if(abean == null) {
			req.setAttribute("msg", "Invalid Admin Credentials!!!");
			req.getRequestDispatcher("Adminlogin.html").forward(req, res);
		}
		else {
			HttpSession session = req.getSession(true);                //Creating a session
			session.setAttribute("abean", abean);
			req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
		}
	}

}
