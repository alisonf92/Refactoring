package refactoring;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReportDAO {

	Connection conn;
	PreparedStatement pst;
	
	public Connection getConnection() {
		Connection con;
		con = ConnectionFactory.getInstance().getConnection();
		return con;
	}
}
