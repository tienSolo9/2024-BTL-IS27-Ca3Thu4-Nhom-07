package project_zoo.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectSql {
	static final String DB_URL = "jdbc:mysql://localhost:3306/zoo";
	static final String USER = "root";
	static final String PASS = "hvnh2004";
	
	public static Connection getConnection() {
		try {
			Connection connect = DriverManager.getConnection(DB_URL,USER,PASS);
			return connect;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
