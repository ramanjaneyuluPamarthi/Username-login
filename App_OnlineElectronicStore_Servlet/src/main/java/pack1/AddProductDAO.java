package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO {
	public int insertProducts(ProductBean pb) {
		Connection con = DBConnect.getCon();
		int rowcount = 0;
	   // ProductBean pbean = null;
		try {
			PreparedStatement pstm = con.prepareStatement("insert into product values (?,?,?,?,?)");
			pstm.setString(1, pb.getPid());
			pstm.setString(2, pb.getPname());
			pstm.setString(3, pb.getPcompany());
			pstm.setDouble(4, pb.getPprice());
			pstm.setInt(5, pb.getPqty());
			rowcount = pstm.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;			
	}

}
