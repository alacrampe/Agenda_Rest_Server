package fr.ingesup.agenda.ws.dao.impl;

import java.util.List;



import fr.ingesup.agenda.ws.dao.DAOService;
import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.models.Event;
import fr.ingesup.agenda.ws.serializer.EventSerializer;

public class EventDAOServiceImpl implements DAOService {

	@Override
	public <T> List<T> getAll(Class<T> objClass) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void save(T obj) throws DAOException {
		// TODO Auto-generated method stub
		if(obj.getClass().equals((Event.class)))
		{
			EventSerializer.addEvent((Event) obj);
		}
	}

	@Override
	public <T> T get(String id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void update(T obj) throws DAOException {
		// TODO Auto-generated method stub
		if(obj.getClass().equals(Event.class))
		{
			String id=((Event) obj).getId();
			Event e=EventSerializer.getEvent(id);
			EventSerializer.replaceEvent(e, (Event) obj);
			
		}

	}

	@Override
	public void delete(String id) throws DAOException {
		// TODO Auto-generated method stub
		
		Event e=EventSerializer.getEvent(id);
		EventSerializer.removeEvent(e);
		
	}

}
