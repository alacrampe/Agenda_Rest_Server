package fr.ingesup.agenda.ws.models;

public class Day extends Event {
	public Day() {
		this.type = Type.DAY;
	}
	
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
