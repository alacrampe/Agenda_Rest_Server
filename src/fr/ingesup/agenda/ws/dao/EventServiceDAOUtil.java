package fr.ingesup.agenda.ws.dao;

import java.util.List;

import fr.ingesup.agenda.ws.dao.impl.EventServiceDAOImpl;
import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.models.Event;
import fr.ingesup.agenda.ws.models.WSEventsInput;

public class EventServiceDAOUtil {
	private static EventServiceDAO _service;
	
	private static EventServiceDAO getService() {
		if(_service == null) {
			_service = new EventServiceDAOImpl();
		}
		return _service;
	}

	public static List<Event> getAllEvents(WSEventsInput filter, String userToken) throws DAOException {
		return getService().getAllEvents(filter, userToken);
	}
	
	public static String save(Event event) throws DAOException {
		return getService().save(event);
	}
	
	public static Event get(String id) throws DAOException {
		return getService().get(id);
	}
	
	public static Event update(Event event) throws DAOException {
		return getService().update(event);
	}
	
	public static void delete(String id) throws DAOException {
		getService().delete(id);
	}
}
=======
package fr.ingesup.agenda.ws.dao;

import java.util.List;

import fr.ingesup.agenda.ws.dao.impl.EventServiceDAOImpl;
import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.models.Event;
import fr.ingesup.agenda.ws.models.WSEventsInput;

public class EventServiceDAOUtil {
	private static EventServiceDAO _service;
	
	private static EventServiceDAO getService() {
		if(_service == null) {
			_service = new EventServiceDAOImpl();
		}
		return _service;
	}

	public static List<Event> getAllEvents(WSEventsInput filter, String userToken) throws DAOException {
		return getService().getAllEvents(filter, userToken);
	}
	
	public static String save(Event event, String token) throws DAOException {
		return getService().save(event, token);
	}
	
	public static Event get(String id) throws DAOException {
		return getService().get(id);
	}
	
	public static Event update(Event event) throws DAOException {
		return getService().update(event);
	}
	
	public static void delete(String id) throws DAOException {
		getService().delete(id);
	}
}
