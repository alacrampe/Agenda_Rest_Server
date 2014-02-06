package fr.ingesup.agenda.ws.models;

import java.io.Serializable;

public class Time implements Serializable{
	private static final long serialVersionUID = 8893778387593158153L;
	private int hour;
	private int minute;
	
	public Time() {
		super();
	}
	
	public Time(int hour, int minute) {
		super();
		this.hour = hour;
		this.minute = minute;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
}
