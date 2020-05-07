package test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modele.Client;

public class TestModeleClient {

	// La classe à tester :
	private Client client;

	@Before
	public void setUp() {
		client = new Client();
		client.setNom("monNom");
		client.setPrenom("monPrenom");
	}

	@Test
	public void testGetterNom() {
		assertNotNull(client.getNom());
	}

	@Test
	public void testGetterPrenomNonNull() {
		assertNotNull(client.getPrenom());
	}

	@Test
	public void testGetterPrenom() {
		assertEquals("monPrenom", client.getPrenom());
	}

	@Test
	public void testAvecMock() {
		Client mockClient = mock(Client.class);
		when(mockClient.getNom()).thenReturn("JOYEUX");
		Assert.assertTrue("JOYEUX" == mockClient.getNom());
		//assertEquals("JOYEUX", mockClient.getNom());
	}
}
