package fr.ingesup.agenda.ws.models;

import java.io.Serializable;

public class Time implements Serializable{
	private int hour;
	private int minutes;
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}


}
