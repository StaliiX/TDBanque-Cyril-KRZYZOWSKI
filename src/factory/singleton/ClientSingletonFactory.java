package factory.singleton;

import modele.Client;
import modele.PersonnePhysique;

public class ClientSingletonFactory {

	private static ClientSingletonFactory instance;
	private static Client client;

	private ClientSingletonFactory() {

	}

	public static ClientSingletonFactory getInstance() {
		if (instance == null) {
			instance = new ClientSingletonFactory();
		}
		return instance;
	}

	public Client createClient(String nom, String prenom) {
		if (client == null) {
			PersonnePhysique client = new PersonnePhysique();
			client.setNom(nom);
			client.setPrenom(prenom);
		}
		return client;
	}

}
