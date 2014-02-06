package fr.ingesup.agenda.ws.dao;

import java.util.List;

import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.models.Event;
import fr.ingesup.agenda.ws.models.WSEventsInput;

public interface EventServiceDAO {
	public List<Event> getAllEvents(WSEventsInput filter, String userToken) throws DAOException;
	
	/** @return the event id */
	public String save(Event event, String token) throws DAOException;
	public Event get(String id) throws DAOException;
	public Event update(Event event) throws DAOException;
	public void delete(String id) throws DAOException;
}
