package test.database.mysql;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import database.mysql.DataBaseMySql;

public class DataBaseMySqlTest {

	private DataBaseMySql myDb;

	@Before
	public void setUp() {
		myDb = new DataBaseMySql();
	}

	@Test
	public void testConnectionIsOk() {
		assertTrue(myDb.connectDb());
	}

}
