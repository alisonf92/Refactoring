package refactoring;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

	
	String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
	String conUrl = "jdbc:odbc:Registration";
	String dbUser = "root";
	String dbPwd = "root";

	private static ConnectionFactory connectionFactory = null;

	private ConnectionFactory() {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection()  {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(conUrl, dbUser, dbPwd);

		} catch (Exception e) {
			e.toString();
		}
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
