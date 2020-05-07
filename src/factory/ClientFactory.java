package factory;

import enumerations.client.ETypeClient;
import modele.Client;
import modele.PersonneMorale;
import modele.PersonnePhysique;

public class ClientFactory {

	private ClientFactory() {
		// le constructeur est privé .. on ne peut pas instancier la classe.

	}

	public static Client getClient(ETypeClient typeClient, String nom, String prenom) throws Exception {
		switch (typeClient) {
		case MORALE:
			return createPersonneMorale(nom, prenom);
		case PHYSIQUE:
			return createPersonnePhysique(nom, prenom);
		default:
			throw new Exception("Type de client Inconnu");
		}

	}

	private static Client createPersonneMorale(String nom, String prenom) {
		PersonneMorale client = new PersonneMorale();
		client.setNom(nom);
		client.setPrenom(prenom);
		return client;
	}

	private static Client createPersonnePhysique(String nom, String prenom) {
		PersonnePhysique client = new PersonnePhysique();
		client.setNom(nom);
		client.setPrenom(prenom);
		return client;
	}

}
