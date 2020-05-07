package banqueTests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import banque.Client;
import banque.Compte;
import banque.CompteAvecDecouvert;

public class TestCompteEtClient {
	
	CompteAvecDecouvert compte;
	Client client;
	
	@Before
	public void setUp() {
		compte = new CompteAvecDecouvert("CompteTestCreation", "ClientDeCreation", 220, 20); //Je cr�� un compte avec d�couvert pour m'assurer que m�me le d�couvert soit bien cr��.
		client = new Client("ClientDeCreation", "20 Rue des Mandarines", "Jos�");
	}

	@Test
	public void testCreationCompte() throws SQLException { //Test pour voir si un compte est bien cr��
		assertTrue(compte.getidCompte().equals("CompteTestCreation") && compte.getidClient().equals("ClientDeCreation") && compte.getSolde() == 220 && compte.getDecouvert() == 20);
	}

	@Test
	public void testCreationClient() throws SQLException { //Test pour voir si un client est bien cr��
		assertTrue(client.getId().equals("ClientDeCreation") && client.getAdresse().equals("20 Rue des Mandarines") && client.getNom().equals("Jos�"));
	}
	
	//TODO : 

}
