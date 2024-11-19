package pack1;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection con = null;
    private DBConnect() {}
    static {
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		con = DriverManager.getConnection(DBInfo.DBurl,DBInfo.DBUname,DBInfo.DBUpwd);
    		
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static Connection getCon() {
    	return con;
    }
	
}
