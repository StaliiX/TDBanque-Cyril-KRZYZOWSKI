package vue;

import java.util.Iterator;

import controleur.ClientControleur;
import interfaces.vue.IVue;
import modele.Client;

public class ClientVue implements IVue {

	/* La vue connait son controleur */
	private ClientControleur controleur;

	@Override
	public void afficherList() {
		System.out.println("for each : ");
		for (Client client : controleur.getClients()) {
			System.out.println(client.getNom());
			System.out.println(client.getPrenom());
		}

		// pattern iterator -
		System.out.println("pattern iteratorlistClient :");
		Iterator<Client> it = controleur.getClients().iterator();
		while (it.hasNext()) {
			Client client = it.next();
			System.out.println(client.getNom());
			System.out.println(client.getPrenom());
		}
	}

	public ClientControleur getControleur() {
		return controleur;
	}

	public void setControleur(ClientControleur controleur) {
		this.controleur = controleur;
	}
}
