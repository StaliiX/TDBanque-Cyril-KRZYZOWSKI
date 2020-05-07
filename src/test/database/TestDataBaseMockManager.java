package test.database;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import database.DatabaseMockManager;

public class TestDataBaseMockManager {

	private DatabaseMockManager mock;

	@Before
	public void setUp() {
		mock = new DatabaseMockManager();
	}

	@Test
	public void testGetClientEnMemoireEstNonNull() {
		assertNotNull(mock.getClientsEnMemoire(false));
	}

	@Test
	public void testGetClientEnMemoireRenvoieAuMoins2Elements() {
		assertTrue(mock.getClientsEnMemoire(true).size() >= 2);
	}
}
