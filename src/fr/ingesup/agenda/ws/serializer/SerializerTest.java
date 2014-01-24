package fr.ingesup.agenda.ws.serializer;

import java.util.ArrayList;




import fr.ingesup.agenda.ws.models.Date;
import fr.ingesup.agenda.ws.models.Day;
import fr.ingesup.agenda.ws.models.Event;
import fr.ingesup.agenda.ws.models.Event.Type;
import fr.ingesup.agenda.ws.models.Meeting;
import fr.ingesup.agenda.ws.models.Periodicity;

public class SerializerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Periodicity p1=new Periodicity();
		p1.setType(Periodicity.Type.WEEKDAY);
		ArrayList<Integer>al=new ArrayList<Integer>();
		al.add(1);
		p1.setWeekDays(al);
		p1.setRepeat(5);
		
		Date d=new Date();
		d.setDay(10);
		d.setMonth(10);
		d.setYear(2014);
		
		Event ev1=new Day(d);
		ev1.setDescription("DAY");
		ev1.setName("CD");
		ev1.setPeriodicity(p1);
		
		Meeting m=new Meeting();
		m.setDescription("MEETING");
		m.setName("CD");
		
		
		EventSerializer.Load();
		EventSerializer.addEvent(ev1);
		EventSerializer.addEvent(m);
		EventSerializer.Save();
		
		System.out.println(EventSerializer.getAll().get(0).getDescription());
		System.out.println(EventSerializer.getAll().get(1).getDescription());
		
		EventSerializer.getAll().clear();
		
		EventSerializer.Load();
		
		System.out.println(EventSerializer.getAll().get(0).getDescription());
		System.out.println(EventSerializer.getAll().get(1).getDescription());
		
	}

}
