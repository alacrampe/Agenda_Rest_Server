package fr.ingesup.agenda.ws.dao;

import fr.ingesup.agenda.ws.dao.impl.UserServiceDAOImpl;
import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.models.User;

public class UserServiceDAOUtil {
	private static UserServiceDAO _service;
	
	private static UserServiceDAO getService() {
		if(_service == null) {
			_service = new UserServiceDAOImpl();
		}
		return _service;
	}

	public static User createAccount(User user) throws DAOException {
		return getService().createAccount(user);
	}
	
	public static User get(String id) throws DAOException {
		return getService().get(id);
	}
	
	public static User update(User User) throws DAOException {
		return getService().update(User);
	}
}
