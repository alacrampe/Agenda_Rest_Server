package fr.ingesup.agenda.ws.dao;

import java.util.List;

import fr.ingesup.agenda.ws.exceptions.DAOException;

public interface DAOService {
	public <T> List<T> getAll(Class<T> objClass) throws DAOException;
	public <T> void save(T obj) throws DAOException;
	public <T> T get(String id) throws DAOException;
	public <T> void update(T obj) throws DAOException;
	public void delete(String id) throws DAOException;
}