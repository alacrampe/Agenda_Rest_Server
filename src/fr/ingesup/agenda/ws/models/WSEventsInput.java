package fr.ingesup.agenda.ws.models;

import java.util.List;

import fr.ingesup.agenda.ws.models.Event.Type;

public class WSEventsInput {
	private Date dateBegin;
	private Date dateEnd;
	private Time timeBegin;
	private Time timeEnd;
	private List<Type> eventTypes;
	
	public Date getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public Time getTimeBegin() {
		return timeBegin;
	}
	public void setTimeBegin(Time timeBegin) {
		this.timeBegin = timeBegin;
	}
	public Time getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Time timeEnd) {
		this.timeEnd = timeEnd;
	}
	public List<Type> getEventTypes() {
		return eventTypes;
	}
	public void setEventTypes(List<Type> eventTypes) {
		this.eventTypes = eventTypes;
	}
}