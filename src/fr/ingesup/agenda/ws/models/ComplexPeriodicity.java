package fr.ingesup.agenda.ws.models;

import java.io.Serializable;

public class ComplexPeriodicity implements Serializable{
	private int day;
	private int numberInMonth;
	private int month;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getNumberInMonth() {
		return numberInMonth;
	}
	public void setNumberInMonth(int numberInMonth) {
		this.numberInMonth = numberInMonth;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
}