package ljs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
	public Connection getConnection()
	{
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://daajfaaxtliv.mysql.sae.sina.com.cn:10248/ljs";
			String username = "a642206514";
			String password = "ljs19970310";
			conn = DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
}
