package fr.ingesup.agenda.ws.dao;

import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.models.User;

public interface UserServiceDAO {
	/** @return the User */
	public User createAccount(User User) throws DAOException;
	public User get(String id) throws DAOException;
	public User update(User User) throws DAOException;
}
