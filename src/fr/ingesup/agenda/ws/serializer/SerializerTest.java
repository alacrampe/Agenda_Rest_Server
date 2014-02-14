package fr.ingesup.agenda.ws.serializer;

import java.util.ArrayList;
import java.util.Arrays;

import fr.ingesup.agenda.ws.dao.EventServiceDAOUtil;
import fr.ingesup.agenda.ws.dao.UserServiceDAOUtil;
import fr.ingesup.agenda.ws.dao.impl.EventServiceDAOImpl;
import fr.ingesup.agenda.ws.dao.impl.UserServiceDAOImpl;
import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.models.Date;
import fr.ingesup.agenda.ws.models.Day;
import fr.ingesup.agenda.ws.models.Event;
import fr.ingesup.agenda.ws.models.Meeting;
import fr.ingesup.agenda.ws.models.PointInTime;
import fr.ingesup.agenda.ws.models.Time;
import fr.ingesup.agenda.ws.models.User;
import fr.ingesup.agenda.ws.models.WSEventsInput;
import fr.ingesup.agenda.ws.utils.Log;

public class SerializerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Periodicity p1=new Periodicity();
//		p1.setType(Periodicity.Type.WEEKDAY);
//		ArrayList<Integer>al=new ArrayList<Integer>();
//		al.add(1);
//		p1.setWeekDays(al);
//		p1.setRepeat(5);
//		
//		Date d=new Date();
//		d.setDay(10);
//		d.setMonth(10);
//		d.setYear(2014);
//		
//		Event ev1=new Day(d);
//		ev1.setDescription("DAY");
//		ev1.setName("CD");
//		ev1.setPeriodicity(p1);
//		
//		Meeting m=new Meeting();
//		m.setDescription("MEETING");
//		m.setName("CD");
//		
//		
//		EventSerializer.Load();
//		EventSerializer.addEvent(ev1);
//		EventSerializer.addEvent(m);
//		EventSerializer.Save();
//		
//		System.out.println(EventSerializer.getAll().get(0).getDescription());
//		System.out.println(EventSerializer.getAll().get(1).getDescription());
//		
//		EventSerializer.getAll().clear();
//		
//		EventSerializer.Load();
//		
//		System.out.println(EventSerializer.getAll().get(0).getDescription());
//		System.out.println(EventSerializer.getAll().get(1).getDescription());
		
		User user=new User();
		user.setEmail("abcd@dcba.com");
		user.setUserToken("abcd");
		
		
	
		Day day=new Day();
		day.setDate(new Date(01, 05, 2013));
		day.setDescription("Le 1er mai est un jour f�ri� fran�ais");
		day.setName("F�te du travail");
		day.setUser(user);
		
		Meeting m=new Meeting();
		m.setName("Projet fil rouge");
		m.setDescription("Rendez-vous avec le groupe pour discuter du projet fil rouge");
		m.setParticipants(Arrays.asList(new String[] {"olivier", "daniel", "xavier", "samuel", "arnaud"}));
		m.setPointBegin(new PointInTime(2013, 01, 30, 16, 30));
		day.setUser(user);
		System.out.println("Before Try");
		try {
			UserServiceDAOUtil.createAccount(user);
			EventServiceDAOUtil.save(day,"abcd");

			EventServiceDAOUtil.save(m,"abcd");
			
			System.out.println("2");
//			Meeting meeting = (Meeting) EventServiceDAOUtil.get("2");
//			System.out.println(meeting.toString());
			WSEventsInput filter=new WSEventsInput();
			filter.setDateBegin(new Date(1,1,2010));
			filter.setDateEnd(new Date(1,1,2014));
			filter.setTimeBegin(new Time(0,0));
			filter.setTimeEnd(new Time(0,0));
			filter.setEventTypes(new ArrayList<Event.Type>());
			
			System.out.println("3");
			
			ArrayList<Event> events=(ArrayList<Event>) EventServiceDAOUtil.getAllEvents(filter, "abcd");
			
			System.out.println("Count");
			System.out.println(events.size());
		} catch (DAOException e) {
			Log.error(e);
			System.out.println(e.getMessage());

		}
		
	}
}
