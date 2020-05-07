package controleur;

import java.util.List;

import facade.DaoFacadeManager;
import interfaces.vue.IVue;
import modele.Client;

/***
 * Le contr�leur de la vue :
 * 
 * @author LocalIT
 *
 */
public class ClientControleur {

	// Le contr�leur connait sa vue :
	private IVue vue;

	// Le contr�leur acc�de au manager :
	private DaoFacadeManager manager;

	/* Le controleur connait sa vue */
	public ClientControleur(IVue vue) {
		this.vue = vue;
		this.manager = new DaoFacadeManager();
	}

	public ClientControleur(IVue vue, DaoFacadeManager manager) {
		this.vue = vue;
		this.manager = manager;
	}

	public IVue getVue() {
		return vue;
	}

	public List<Client> getClients() {
		return manager.getListClient();
	}

	public Client getPremierClient() {
		return manager.getListClient().get(0);
	}
}
