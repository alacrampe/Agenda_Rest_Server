package fr.ingesup.agenda.ws.models;

public class Day extends Event {
	private static final long serialVersionUID = -6781144076483997049L;

	public Day() {
		this.type = Type.D;
	}
	
	public Day(Date date) {
		super();
		this.type = Type.D;
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
