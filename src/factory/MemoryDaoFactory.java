package factory;

import database.MemoryClientDao;
import interfaces.dao.IClientDao;

public class MemoryDaoFactory extends DaoFactory {

	@Override
	public IClientDao getClientDao() {
		return MemoryClientDao.getInstance();
	}

}
