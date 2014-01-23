package fr.ingesup.agenda.ws.utils;

import fr.ingesup.agenda.ws.models.Day;
import fr.ingesup.agenda.ws.models.Event.Type;
import fr.ingesup.agenda.ws.models.Meeting;
import fr.ingesup.agenda.ws.models.Period;
import fr.ingesup.agenda.ws.models.Task;

public class EventUtils {
	public static Class getEventClassFromType(Type eventType) {
		switch(eventType) {
		case DAY: return Day.class;
		case MEETING: return Meeting.class;
		case PERIOD: return Period.class;
		case TASK:return Task.class;
		default: return null;
		}
	}
}
