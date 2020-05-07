package dao;

import java.util.List;

import database.DatabaseMockManager;
import interfaces.dao.IDao;
import modele.Client;

public class ClientDao implements IDao<Client> {

	private DatabaseMockManager myMockData = new DatabaseMockManager();

	@Override
	public void create(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getList() {
		return myMockData.getClientsEnMemoire(true);
	}
}
