package banque;

import java.sql.*;

public class BDDConn {
	
	private String lienBDD = "jdbc:mysql://localhost:3306/applicationbanque?useUnicode=true&serverTimezone=UTC";
	private String nomUtilisateur = "root";
	private String motDePasse = "";
	
	public Connection Connexion() throws SQLException
	{
		Connection conn = DriverManager.getConnection(lienBDD, nomUtilisateur, motDePasse);
		
		return conn;
	}

}
