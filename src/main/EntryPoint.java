package main;

import static enumerations.client.ETypeClient.MORALE;
import static enumerations.client.ETypeClient.PHYSIQUE;
import static factory.ClientFactory.getClient;

import java.util.Iterator;
import java.util.List;

import controleur.ClientControleur;
import enumerations.persistance.EPersistance;
import factory.DaoFactory;
import modele.Client;
import vue.ClientVue;

public class EntryPoint {

	public static void main(String[] args) throws Exception {
		System.out.println("-------> I. Partie Factory - Singleton : ");
		Client client1 = getClient(MORALE, "JOYEUX", "STEPHANE");
		Client client2 = getClient(PHYSIQUE, "JOYEUX", "LUCAS");

		System.out.println("Clients sont identiques : " + (client1 == client2));
		System.out.println("Imprimantes sont identiques : " + (client1.getImprimante() == client2.getImprimante()));

		System.out.println("");
		System.out.println("-------> II. Partie MVC : ");
		ClientVue vue = new ClientVue();
		ClientControleur controleur = new ClientControleur(vue);
		vue.setControleur(controleur);
		controleur.getVue().afficherList();

		System.out.println("");
		System.out.println("-------> III. Partie DAO : ");
		DaoFactory daos = DaoFactory.getDaoFactory(EPersistance.MEMORY);
		List<Client> clients = daos.getClientDao().getList();
		for (Iterator iterator = clients.iterator(); iterator.hasNext();) {
			Client client = (Client) iterator.next();
			System.out.println(client.getNom() + " "  + client.getPrenom());
		}
	}

}
