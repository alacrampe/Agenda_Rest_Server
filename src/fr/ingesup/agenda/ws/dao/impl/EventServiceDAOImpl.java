package fr.ingesup.agenda.ws.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import fr.ingesup.agenda.ws.dao.EventServiceDAO;
import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.models.Date;
import fr.ingesup.agenda.ws.models.Day;
import fr.ingesup.agenda.ws.models.Event;
import fr.ingesup.agenda.ws.models.Event.Type;
import fr.ingesup.agenda.ws.models.Meeting;
import fr.ingesup.agenda.ws.models.Period;
import fr.ingesup.agenda.ws.models.Task;
import fr.ingesup.agenda.ws.models.Time;
import fr.ingesup.agenda.ws.models.User;
import fr.ingesup.agenda.ws.models.WSEventsInput;
import fr.ingesup.agenda.ws.serializer.EventSerializer;
import fr.ingesup.agenda.ws.serializer.UserSerializer;

public class EventServiceDAOImpl implements EventServiceDAO {

	@Override
	public List<Event> getAllEvents(WSEventsInput filter, String userToken)
			throws DAOException {
		ArrayList<Event> evs=EventSerializer.getAll();
		ArrayList<Event> filteredList=new ArrayList<Event>();
		
		DateTime fB=new DateTime(filter.getDateBegin().getYear(),filter.getDateBegin().getMonth(),filter.getDateBegin().getDay(), filter.getTimeBegin().getHour(), filter.getTimeBegin().getMinute());
		DateTime fE=new DateTime(filter.getDateEnd().getYear(),filter.getDateEnd().getMonth(),filter.getDateEnd().getDay(), filter.getTimeEnd().getHour(), filter.getTimeEnd().getMinute());
		
		Interval per = new Interval(fB, fE);
		
		boolean includeDays=false;
		boolean includePeriods=false;
		boolean includeTasks=false;
		boolean includeMeetings=false;
		
		if(filter.getEventTypes().size()<=0)
		{
			includeDays=true;
			includePeriods=true;
			includeTasks=true;
			includeMeetings=true;
		}
		else
		{
			for(Event.Type type : filter.getEventTypes())
			{
				if(type==Type.D)
				{
					includeDays=true;
				}
				else if(type==Type.M)
				{
					includeMeetings=true;
				}
				else if(type==Type.P)
				{
					includePeriods=true;
				}
				else if(type==Type.T)
				{
					includeTasks=true;
				}
			}
		}
		for(Event e : evs)
		{
			if(e.getUser().getUserToken().equals(userToken))
			{
				ArrayList<Event> repeats=e.generateRepeats();
				
				for(Event r : repeats)
				{
					if(r.getClass().equals(Day.class) && includeDays)
					{
						Date da=((Day) r).getDate();
						DateTime d=new DateTime(da.getYear(),da.getMonth(),da.getDay(), 0 , 0);
						DateTime d2=new DateTime(da.getYear(),da.getMonth(),da.getDay(), 23 , 59);
						Interval day=new Interval(d, d2);
						
						if(per.overlaps(day))
						{
							filteredList.add(r);
						}
					}
					else if(r.getClass().equals(Period.class) && includePeriods)
					{
						Date da=((Period) r).getDateBegin();
						DateTime d=new DateTime(da.getYear(),da.getMonth(),da.getDay(), 0 , 0);
						Date da2=((Period) r).getDateEnd();
						DateTime d2=new DateTime(da2.getYear(),da2.getMonth(),da2.getDay(), 23 , 59);
						Interval period=new Interval(d, d2);
						
						if(per.overlaps(period))
						{
							filteredList.add(r);
						}
					}
					else if(r.getClass().equals(Meeting.class) && includeMeetings)
					{
						Date da=((Meeting) r).getPointBegin().getDate();
						Time ti=((Meeting) r).getPointBegin().getTime();
						
						DateTime d= new DateTime(da.getYear(), da.getMonth(), da.getDay(), ti.getHour(), ti.getMinute());
						
						Date da2=((Meeting) r).getPointBegin().getDate();
						Time ti2=((Meeting) r).getPointBegin().getTime();
						
						DateTime d2= new DateTime(da2.getYear(), da2.getMonth(), da2.getDay(), ti2.getHour(), ti2.getMinute());
						
						Interval meeting=new Interval(d, d2);
						
						if(per.overlaps(meeting))
						{
							filteredList.add(r);
						}
					}
					else if(r.getClass().equals(Task.class) && includeTasks)
					{
						Date da=((Task) r).getPointBegin().getDate();
						Time ti=((Task) r).getPointBegin().getTime();
						
						DateTime d= new DateTime(da.getYear(), da.getMonth(), da.getDay(), ti.getHour(), ti.getMinute());
						
						Date da2=((Task) r).getPointBegin().getDate();
						Time ti2=((Task) r).getPointBegin().getTime();
						
						DateTime d2= new DateTime(da2.getYear(), da2.getMonth(), da2.getDay(), ti2.getHour(), ti2.getMinute());
						
						Interval meeting=new Interval(d, d2);
						
						if(per.overlaps(meeting))
						{
							filteredList.add(r);
						}
					}
				}
			}
			
		}
		
		return filteredList;
	}

	@Override
	public String save(Event event, String token) throws DAOException {
//		return EventSerializer.addEvent(event);
		User u=UserSerializer.getUserByToken(token);
		
		if(u!=null)
		{
			event.setUser(u);
			EventSerializer.addEvent(event);
		}
		else
		{
			throw new DAOException();
		}
		return "OK";
	}

	@Override
	public Event get(String id) throws DAOException {
		return EventSerializer.getEvent(id);
	}

	@Override
	public Event update(Event event) throws DAOException {
		// TODO Implementation
		Event e=EventSerializer.getEvent(event.getId());
		EventSerializer.replaceEvent(e, event);
		return EventSerializer.getEvent(event.getId());
	}

	@Override
	public void delete(String id) throws DAOException {
		Event e=EventSerializer.getEvent(id);
		EventSerializer.removeEvent(e);
	}

}