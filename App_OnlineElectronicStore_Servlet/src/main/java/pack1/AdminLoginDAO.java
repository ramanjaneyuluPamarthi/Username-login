package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginDAO {
	public AdminBean checkAdminLogin(String Username,String Password)  {
		AdminBean abean = null;
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement pstm = con.prepareStatement("select * from admin where uname=? and password=?");
			pstm.setString(1, Username);
			pstm.setString(2, Password);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				abean= new AdminBean();
				abean.setUsername(rs.getString(1));
				abean.setPassword(rs.getString(2));
				abean.setFirstname(rs.getString(3));
				abean.setLastname(rs.getString(4));
				abean.setAddress(rs.getString(5));
				abean.setMail_id(rs.getString(6));
				abean.setMobile(rs.getLong(7));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return abean;
	}

}
