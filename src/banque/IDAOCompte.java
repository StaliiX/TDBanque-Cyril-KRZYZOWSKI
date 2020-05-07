package banque;

import java.sql.SQLException;

public interface IDAOCompte {
	
	void create(Compte c) throws SQLException;
	
	void update(Compte c) throws SQLException;
	
	void delete(Compte c) throws SQLException;
	
	Compte read(Compte c) throws SQLException;

}
