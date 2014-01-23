package fr.ingesup.agenda.ws.models;

import java.io.Serializable;

public class Event implements Serializable{
	protected Type type;
	
	public enum Type {
		TASK, MEETING, DAY, PERIOD
	}

	protected String id;
	protected String name;
	protected String description;
	protected Periodicity periodicity;
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Periodicity getPeriodicity() {
		return periodicity;
	}
	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}
}
