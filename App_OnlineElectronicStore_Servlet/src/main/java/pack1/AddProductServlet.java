package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false); // checking weather session is avilable or not

		if (session == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("Adminlogin.html").forward(req, res);

		} else {
			ProductBean pbean = new ProductBean();
			// PrintWriter pw = res.getWriter();
			// pw.println(req.getParameter("pid")+req.getParameter("pname")+req.getParameter("pcompany")+req.getParameter("pprice")+req.getParameter("pqty"));

			pbean.setPid(req.getParameter("pid"));
			pbean.setPname(req.getParameter("pname"));
			pbean.setPcompany(req.getParameter("pcompany"));
			pbean.setPprice(Double.parseDouble(req.getParameter("pprice")));
			pbean.setPqty(Integer.parseInt(req.getParameter("pqty")));

			int rowcount = new AddProductDAO().insertProducts(pbean);
			if (rowcount > 0) {
				req.setAttribute("msg", "Products Added Successfully!!!");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			} else {
				req.setAttribute("msg", "Products are Not Updated");
				req.getRequestDispatcher("AddProduct.html").forward(req, res);
			}

		}
	}

}
