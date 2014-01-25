package fr.ingesup.agenda.ws.models;

public class Period extends Event {
	public Period() {
		this.type = Type.P;
	}
	
	private Date dateBegin;
	private Date dateEnd;
	
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
}
