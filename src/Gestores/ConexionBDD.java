package Gestores;

import java.sql.*;

public class ConexionBDD {
	
	static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/tpdied",
            "root", "Ramona");
	}
	
}
