package test.dao.factory;

import static enumerations.client.ETypeClient.MORALE;
import static factory.ClientFactory.getClient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import modele.Client;

public class TestClientFactory {

	private Client client;

	@Before
	public void setUp() throws Exception {
		client = getClient(MORALE, "nom1", "prenom1");
	}

	@Test
	public void testNouvelleInstanceClientEstFabriquee() throws Exception {
		assertNotEquals(client, getClient(MORALE, "nom1", "prenom1"));
	}

	@Test
	public void testInstanceImprimanteDeClientEstIdentique() throws Exception {
		assertEquals(client.getImprimante(), getClient(MORALE, "nom1", "prenom1").getImprimante());
	}

}
