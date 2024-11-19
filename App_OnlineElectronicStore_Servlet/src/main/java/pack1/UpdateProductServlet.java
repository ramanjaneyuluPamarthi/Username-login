package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null) {
			req.getRequestDispatcher("Adminlogin.html").forward(req, res);
		} else {
			String pid = req.getParameter("pid");
			ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("ProductList");
			ProductBean pb = null;
			Iterator<ProductBean> i = al.iterator();
			while (i.hasNext()) {
				pb = i.next();
				if (pid.equals(pb.getPid())) {
					break;
				}
				pb.setPname(req.getParameter("pname"));
				pb.setPcompany(req.getParameter("pcompany"));
				pb.setPprice(Double.parseDouble(req.getParameter("pprice")));
				pb.setPqty(Integer.parseInt(req.getParameter("pqty")));
				//al.add(pb);

				int rowcount = new UpdateProductDAO().updateProducts(pb);
				
				if(rowcount>0) {
					
					req.setAttribute("msg", "Products Updated !!!");
					req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
				}
			}
		}

	}

}
