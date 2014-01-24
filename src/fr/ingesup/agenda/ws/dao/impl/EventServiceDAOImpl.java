package fr.ingesup.agenda.ws.dao.impl;

import java.util.List;

import fr.ingesup.agenda.ws.dao.EventServiceDAO;
import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.models.Event;
import fr.ingesup.agenda.ws.models.WSEventsInput;

public class EventServiceDAOImpl implements EventServiceDAO {

	@Override
	public List<Event> getAllEvents(WSEventsInput filter, String userToken)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(Event event) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event get(String id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event update(Event event) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
