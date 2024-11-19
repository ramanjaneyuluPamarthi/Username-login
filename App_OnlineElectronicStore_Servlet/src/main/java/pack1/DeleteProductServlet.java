package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session == null) {
			req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
		}
		else {
			ProductBean pb= new ProductBean();
			pb.setPid(req.getParameter("pid"));
			 int rowcount = new DeleteProductDAO().deleteProducts(pb);
			 
			 if (rowcount>1) {
				req.setAttribute("msg", "Product Deleted");
				req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
			}
			 else {
				 req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
			 }
			//	Object attribute = session.getAttribute("pid");
		}
	}

}
