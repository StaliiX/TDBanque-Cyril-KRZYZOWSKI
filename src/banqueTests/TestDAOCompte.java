package banqueTests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import banque.Compte;
import banque.CompteAvecDecouvert;
import banque.DAOCompte;

public class TestDAOCompte {
	
	DAOCompte dao;
	@Before
	public void setUp() {
		dao = new DAOCompte();
	}

	@Test
	public void testListeComptesNonNull() throws SQLException { //Test pour voir si la base de donnée renvoie bien la liste des comptes.
		assertNotNull(dao.readAll());
	}

	@Test
	public void testCompteSeCreeBienEtSupprime() throws SQLException { //Test de la création et de la suppression d'un compte
		CompteAvecDecouvert compte = new CompteAvecDecouvert();
		compte.setIDCompte("CompteDeTest");
		compte.setIDClient("IDClientDeTest");
		compte.setSolde(120);
		compte.setDecouvert(140);
		
		dao.create(compte);
		
		CompteAvecDecouvert compteSurBDD = (CompteAvecDecouvert) dao.read(compte);
		
		assertTrue("CompteDeTest".equals(compteSurBDD.getidCompte()) && "IDClientDeTest".contentEquals(compteSurBDD.getidClient()) && 120 == compteSurBDD.getSolde() && 140==compteSurBDD.getDecouvert());
		assertNotNull(dao.read(compte)); //On vérifie bien que les données récupérées sur la BDD sont ok. Le deuxième test est pas nécessaire
		dao.delete(compte);
		
		assertNull(dao.read(compte));
	}

}
