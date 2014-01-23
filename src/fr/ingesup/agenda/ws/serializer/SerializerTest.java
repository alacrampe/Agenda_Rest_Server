package fr.ingesup.agenda.ws.serializer;

import java.util.ArrayList;

import fr.ingesup.agenda.ws.models.Event;
import fr.ingesup.agenda.ws.models.Event.Type;
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
		
		Event ev1=new Event();
		ev1.setDescription("AB");
		ev1.setName("CD");
		ev1.setPeriodicity(p1);
		
		EventSerializer.Load();
		EventSerializer.addEvent(ev1);
		EventSerializer.Save();
	}

}
