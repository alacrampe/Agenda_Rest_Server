package fr.ingesup.agenda.ws.utils;

import fr.ingesup.agenda.ws.models.Day;
import fr.ingesup.agenda.ws.models.Event.Type;
import fr.ingesup.agenda.ws.models.Meeting;
import fr.ingesup.agenda.ws.models.Period;
import fr.ingesup.agenda.ws.models.Task;

public class EventUtils {
	public static Class getEventClassFromType(Type eventType) {
		switch(eventType) {
		case D: return Day.class;
		case M: return Meeting.class;
		case P: return Period.class;
		case T:return Task.class;
		default: return null;
		}
	}
}
