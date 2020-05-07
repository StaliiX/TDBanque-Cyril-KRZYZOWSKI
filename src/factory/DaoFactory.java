package factory;

import enumerations.persistance.EPersistance;
import interfaces.dao.IClientDao;

public abstract class DaoFactory {

	public static DaoFactory getDaoFactory(EPersistance cible) throws Exception {

		DaoFactory daoF = null;

		switch (cible) {
		case MEMORY:
			daoF = new MemoryDaoFactory();
			break;
		case MYSQL:
			daoF = new MySqlDaoFactory();
			break;
		case XML:
			throw new Exception("Not yet implemented");
		default:
			break;

		}
		return daoF;

	}

	public abstract IClientDao getClientDao();

}
