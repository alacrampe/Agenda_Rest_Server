package fr.ingesup.agenda.ws.models;

import java.io.Serializable;

public class PointInTime implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date date;
	private Time time;
	
	public PointInTime() {
		super();
	}
	public PointInTime(Date date, Time time) {
		super();
		this.date = date;
		this.time = time;
	}
	
	public PointInTime(int year, int month, int day, int hour, int minute) {
		this.date = new Date(day, month, year);
		this.time = new Time(hour, minute);
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
}
