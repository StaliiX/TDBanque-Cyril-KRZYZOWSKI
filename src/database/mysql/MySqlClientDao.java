package database.mysql;

import java.util.List;

import interfaces.dao.IClientDao;
import modele.Client;

public class MySqlClientDao implements IClientDao {

	private static MySqlClientDao instance;

	private MySqlClientDao() {

	}

	public static MySqlClientDao getInstance() {
		if (instance == null) {
			instance = new MySqlClientDao();
		}
		return instance;
	}

	@Override
	public void create(Client objet) {


	}

	@Override
	public void update(Client objet) {

	}

	@Override
	public void delete(Client objet) {


	}

	@Override
	public Client read() {

		return null;
	}

	@Override
	public List<Client> getList() {

		return null;
	}

}
