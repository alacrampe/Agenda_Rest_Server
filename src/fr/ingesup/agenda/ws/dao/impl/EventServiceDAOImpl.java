package fr.ingesup.agenda.ws.dao.impl;

import java.util.List;

import fr.ingesup.agenda.ws.dao.EventServiceDAO;
import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.models.Event;
import fr.ingesup.agenda.ws.models.WSEventsInput;
import fr.ingesup.agenda.ws.serializer.EventSerializer;

public class EventServiceDAOImpl implements EventServiceDAO {

	@Override
	public List<Event> getAllEvents(WSEventsInput filter, String userToken)
			throws DAOException {
		return EventSerializer.getAll();
	}

	@Override
	public String save(Event event) throws DAOException {
//		return EventSerializer.addEvent(event);
		EventSerializer.addEvent(event);
		return "OK";
	}

	@Override
	public Event get(String id) throws DAOException {
		return EventSerializer.getEvent(id);
	}

	@Override
	public Event update(Event event) throws DAOException {
		// TODO Implementation
		return null;
	}

	@Override
	public void delete(String id) throws DAOException {
		Event e=EventSerializer.getEvent(id);
		EventSerializer.removeEvent(e);
	}

}