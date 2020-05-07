package banque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOCompte implements IDAOCompte{
	
private Connection baseDeDonnee;
	
	public DAOCompte() {
		try {
			this.baseDeDonnee = new BDDConn().Connexion() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void create(Compte compte) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = baseDeDonnee.createStatement();
		stmt.executeUpdate("INSERT INTO comptes " + "VALUES('"+compte.getidCompte()+"','"+compte.getidClient()+"',"+compte.getSolde()+","+compte.getDecouvert()+")");
		stmt.close();
	}

	public void update(Compte compte) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = baseDeDonnee.prepareStatement("UPDATE comptes SET idCompte = ?, idClient = ?, Solde = ?, Decouvert = ? WHERE idCompte = '" + compte.getidCompte()+"'");
		ps.setString(1, compte.getidCompte());
		ps.setString(2, compte.getidClient());
		ps.setDouble(3, compte.getSolde());
		ps.setDouble(4, compte.getDecouvert());
		
		ps.executeUpdate();
		ps.close();
	}

	public void delete(Compte compte) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = baseDeDonnee.createStatement();
		stmt.executeUpdate("DELETE FROM comptes WHERE idCompte = '" + compte.getidCompte()+"'");
		
		
		stmt.close();
	}

	@Override
	public Compte read(Compte compte) throws SQLException {
		// TODO Auto-generated method stub
		
		Statement stmt = baseDeDonnee.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM comptes WHERE idCompte = '"+compte.getidCompte()+"'");
		CompteAvecDecouvert resultat = new CompteAvecDecouvert();
		
		if (!rs.next()) {
			System.out.println("Pas de résultat pour ce numéro de compte !");
		}
		else {
			rs.beforeFirst();
			while(rs.next()) {
				resultat.setIDCompte(rs.getString("idCompte"));
				resultat.setIDClient(rs.getString("idClient"));
				resultat.setSolde(rs.getDouble("Solde"));
				resultat.setDecouvert(rs.getDouble("Decouvert"));
			}
			return resultat;
		}
		return null;
	}
	
	public Compte readLast() throws SQLException //Va chercher le dernier compte créé dans la BDD
	{
		Statement stmt = baseDeDonnee.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM comptes");
		CompteAvecDecouvert c = new CompteAvecDecouvert();
		String idCompte = "";
		
		while(rs.next()) {
			idCompte = rs.getString("idCompte");
		}
		
		c.setIDCompte(idCompte);
		return c;
	}
	
	public ArrayList<Compte> readAll() throws SQLException
	{
		Statement stmt = baseDeDonnee.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM comptes");
		ArrayList<Compte> liste = new ArrayList<Compte>();
		while(rs.next()) {
			CompteAvecDecouvert c = new CompteAvecDecouvert();
			c.setIDCompte(rs.getString("idCompte")); 
			c.setIDClient(rs.getString("idClient"));
			c.setSolde(rs.getDouble("Solde"));
			c.setDecouvert(rs.getDouble("Decouvert"));
			liste.add(c);
		}
		return liste;
	}

}
