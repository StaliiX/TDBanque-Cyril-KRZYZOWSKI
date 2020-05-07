package database;

import static enumerations.client.ETypeClient.MORALE;
import static enumerations.client.ETypeClient.PHYSIQUE;

import java.util.ArrayList;
import java.util.List;

import factory.ClientFactory;
import modele.Client;

/**
 * Class de Base de données en mémoire.
 * 
 * @author LocalIT
 *
 */
public class DatabaseMockManager {

	/***
	 * 
	 * @return une liste de clients :
	 */
	public List<Client> getClientsEnMemoire(boolean avecFactory) {
		List<Client> clients = new ArrayList<Client>();
		if (avecFactory) {
			try {
				clients.add(ClientFactory.getClient(MORALE, "JOYEUX", "STEPHANE"));
				clients.add(ClientFactory.getClient(PHYSIQUE, "JOYEUX", "LUCAS"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Client client1 = new Client();
			client1.setNom("JOYEUX");
			client1.setPrenom("STEPHANE");
			clients.add(client1);
			Client client2 = new Client();
			client2.setNom("JOYEUX");
			client2.setPrenom("LUCAS");
			clients.add(client2);
			return clients;
		}
		return clients;
	}

}