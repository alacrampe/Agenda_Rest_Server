package fr.ingesup.agenda.ws.models;

import java.io.Serializable;

public class Date implements Serializable{
	private static final long serialVersionUID = 8893778387593158153L;
	private int day;
	private int month;
	private int year;
	
	public Date() {
		super();
	}
	
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	
	public boolean equals(Date d)
	{
		boolean yearMatch=d.getYear()==this.getYear();
		boolean monthMatch=d.getMonth()==this.getMonth();
		boolean dayMatch=d.getDay()==this.getDay();
		
		return (yearMatch && monthMatch && dayMatch);
	}
	public boolean before(Date d)
	{
		boolean yearMatch=d.getYear()==this.getYear();
		boolean yearInf=d.getYear()<this.getYear();
		
		boolean monthMatch=d.getMonth()==this.getMonth();
		boolean monthInf=d.getMonth()<this.getMonth();
		
		boolean dayMatch=d.getDay()<this.getDay();
		
		boolean dateMatch= (yearInf || (yearMatch && (monthInf || (monthMatch && dayMatch))));
		
		return dateMatch;
	}
	
	public boolean after(Date d)
	{
		return !before(d);
	}
}
