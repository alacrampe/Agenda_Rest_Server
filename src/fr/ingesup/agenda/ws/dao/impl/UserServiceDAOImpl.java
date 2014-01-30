package fr.ingesup.agenda.ws.dao.impl;

import fr.ingesup.agenda.ws.dao.UserServiceDAO;
import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.models.User;
import fr.ingesup.agenda.ws.serializer.UserSerializer;

public class UserServiceDAOImpl implements UserServiceDAO {

	@Override
	public User createAccount(User User) throws DAOException {
		// TODO Auto-generated method stub
		UserSerializer.addUser(User);
		return UserSerializer.getUser(User.getId());
	}

	@Override
	public User get(String id) throws DAOException {
		// TODO Auto-generated method stub
		return UserSerializer.getUser(id);
	}

	@Override
	public User update(User User) throws DAOException {
		// TODO Auto-generated method stub
		User u=UserSerializer.getUser(User.getId());
		UserSerializer.replaceUser(u, User);
		return UserSerializer.getUser(User.getId());
	}
	
}