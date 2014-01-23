package fr.ingesup.agenda.ws.models;

public class Day extends Event {
	public Day() {
		this.type = Type.DAY;
	}
	
	public Day(Date date) {
		super();
		this.type = Type.DAY;
		this.date = date;
	}



	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
