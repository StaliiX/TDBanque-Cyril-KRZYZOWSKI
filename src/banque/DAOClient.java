package banque;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import banque.Client;

public class DAOClient {
	
	private Connection baseDeDonnee;
	
	public DAOClient() {
		try {
			this.baseDeDonnee = new BDDConn().Connexion() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void create(Client client) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = baseDeDonnee.createStatement();
		stmt.executeUpdate("INSERT INTO clients " + "VALUES('"+client.getId()+"','"+client.getAdresse()+"','"+client.getNom()+"')");
		stmt.close();
	}

	public void update(Client client) {
		// TODO Auto-generated method stub

	}

	public void delete(Client client) {
		// TODO Auto-generated method stub

	}

	public Client read() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Client readLast() throws SQLException {
		Statement stmt = baseDeDonnee.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM clients");
		Client c = new Client();
		String idClient = "";
		
		while(rs.next()) {
			idClient = rs.getString("idClient");
		}
		
		c.setId(idClient);
		return c;
	}

}
