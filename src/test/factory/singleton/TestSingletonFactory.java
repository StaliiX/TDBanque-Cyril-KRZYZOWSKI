package test.factory.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import factory.singleton.ClientSingletonFactory;
import modele.Client;

public class TestSingletonFactory {

	private ClientSingletonFactory factory;
	private Client client;

	@Before
	public void setUp() {
		factory = ClientSingletonFactory.getInstance();
		client = factory.createClient("JOYEUX", "LUCAS");
	}

	@Test
	public void testInstanceIsSingleton() {
		assertEquals(factory, ClientSingletonFactory.getInstance());
	}

	@Test
	public void testInstanceClientIsAlwaysTheSame() {
		assertEquals(client, ClientSingletonFactory.getInstance().createClient("JOYEUX", "LUCAS"));
	}

}
