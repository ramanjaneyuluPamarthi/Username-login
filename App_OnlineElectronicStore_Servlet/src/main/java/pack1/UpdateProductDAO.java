package pack1;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO {
	public int updateProducts(ProductBean pb) {
		int rowcount = 0;
		
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement pstm = con.prepareStatement("update product set pname=?,pcompany=?,pprice=?,pqty=? where pid=? ");
			pstm.setString(1,pb.getPname() );
			pstm.setString(2,pb.getPcompany() );
			pstm.setDouble(3,pb.getPprice());
			pstm.setInt(4,pb.getPqty());
			pstm.setString(5, pb.getPid());
			 rowcount = pstm.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}

}
