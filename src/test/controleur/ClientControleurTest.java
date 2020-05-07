package test.controleur;

import static enumerations.client.ETypeClient.PHYSIQUE;
import static factory.ClientFactory.getClient;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controleur.ClientControleur;
import dao.ClientDao;
import facade.DaoFacadeManager;
import modele.Client;
import vue.ClientVue;

/***
 * Test du contrôleur :
 * Mockito : 21.02.2018
 *
 */
public class ClientControleurTest {

	private ClientControleur controleur;

	private ClientDao dao;

	private List<Client> clientsMock;

	@Before
	public void setUp() throws Exception {
		DaoFacadeManager manager = new DaoFacadeManager();
		dao = mock(ClientDao.class);
		manager.setDao(dao);
		controleur = new ClientControleur(new ClientVue(), manager);
		clientsMock = new ArrayList<Client>();
		clientsMock.add(getClient(PHYSIQUE, "NomMock", "PrenomMock"));
	}

	@Test
	public void testRetourneListClient() {
		when(dao.getList()).thenReturn(clientsMock);
		assertEquals(clientsMock.get(0), controleur.getPremierClient());
	}
}
