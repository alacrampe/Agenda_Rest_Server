package fr.ingesup.agenda.ws.models;

import fr.ingesup.agenda.ws.models.Event.Type;

public class WSEventsInput {
	private String userToken;
	private Date dateBegin;
	private Date dateEnd;
	private Time timeBegin;
	private Time timeEnd;
	private Type eventType;
	
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
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
	public Type getEventType() {
		return eventType;
	}
	public void setEventType(Type eventType) {
		this.eventType = eventType;
	}
}
