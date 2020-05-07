package factory;

import database.mysql.MySqlClientDao;
import interfaces.dao.IClientDao;

public class MySqlDaoFactory extends DaoFactory {

	@Override
	public IClientDao getClientDao() {
		return MySqlClientDao.getInstance();
	}
}
