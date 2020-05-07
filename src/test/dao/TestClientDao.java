package test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dao.ClientDao;
import interfaces.dao.IDao;
import modele.Client;

public class TestClientDao {

	private IDao<Client> dao;

	@Before
	public void setUp() {
		dao = new ClientDao();
	}

	@Test
	public void testListeClientNonNull() {
		assertNotNull(dao.getList());
	}

	@Test
	public void testListeClientRenvoieAuMoins2Elements() {
		assertTrue(dao.getList().size() >= 2);
	}
}
