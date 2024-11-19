package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDAO {
	public int deleteProducts(ProductBean pb) {
		int rowcount = 0;
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement pstm = con.prepareStatement("delete from product where pid=?");
			pstm.setString(1, pb.getPid());
			rowcount = pstm.executeUpdate();
		
			
		}catch (Exception e) {
		    e.printStackTrace();;
		}
		return rowcount;
	}

}
