package fr.ingesup.agenda.ws.dao;

import java.util.List;

import fr.ingesup.agenda.ws.dao.impl.EventDAOServiceImpl;
import fr.ingesup.agenda.ws.exceptions.DAOException;

public class EventDAOServiceUtil {
	private static DAOService _service;
	
	private static DAOService getService() {
		if(_service == null) {
			_service = new EventDAOServiceImpl();
		}
		return _service;
	}
	
	public static <T> List<T> getAll(Class<T> objClass) throws DAOException {
		return getService().getAll(objClass);
	}
	
	public static <T> void save(T obj) throws DAOException {
		getService().save(obj);
	}
	
	public static <T> T get(String id) throws DAOException {
		return getService().get(id);
	}	
	
	public static <T> void update(T obj) throws DAOException {
		getService().update(obj);
	}
	
	public static void delete(String id) throws DAOException {
		getService().delete(id);
	}
}
