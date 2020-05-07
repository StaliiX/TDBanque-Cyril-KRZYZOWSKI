package database;

import static enumerations.client.ETypeClient.MORALE;
import static enumerations.client.ETypeClient.PHYSIQUE;

import java.util.ArrayList;
import java.util.List;

import factory.ClientFactory;
import interfaces.dao.IClientDao;
import modele.Client;

public class MemoryClientDao implements IClientDao {

	private static MemoryClientDao instance;

	private MemoryClientDao() {

	}

	public static MemoryClientDao getInstance() {
		if (instance == null) {
			instance = new MemoryClientDao();
		}
		return instance;
	}
	
	@Override
	public void create(Client objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Client objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Client objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getList() {
		List<Client> clients = new ArrayList<>();
		try {
			clients.add(ClientFactory.getClient(MORALE, "JOYEUX", "STEPHANE"));
			clients.add(ClientFactory.getClient(PHYSIQUE, "JOYEUX", "LUCAS"));
		} catch (Exception e) {		
			e.printStackTrace();
		}		
		return clients;
	}

}
