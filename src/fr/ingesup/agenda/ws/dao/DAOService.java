package fr.ingesup.agenda.ws.dao;

public interface DAOService {
	public void getAll(Class objClass) throws DAOException;
	public void save(Object o) throws DAOException;
	public void get(String id) throws DAOException;
	public void update(Object o) throws DAOException;
	public void delete(String id) throws DAOException;
}