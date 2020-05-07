package facade;

import java.util.List;

import dao.ClientDao;
import interfaces.dao.IDao;
import modele.Client;

/***
 * Dao Manager : Injection du DAO dans la classe :
 * 
 * @author LocalIT
 *
 */
public class DaoFacadeManager {

	private IDao<Client> dao;
	
	public DaoFacadeManager() {
		this.dao = new ClientDao();
	}

	// Injection du dao dans le dao Manager :
	public void setDao(IDao<Client> dao) {
		this.dao = dao;
	}

	public List<Client> getListClient() {
		return dao.getList();
	}
}
