package fr.ingesup.agenda.ws.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Event implements Serializable{
	private static final long serialVersionUID = 1L;
	protected Type type;
	
	public enum Type {
		T, M, D, P
	}
	protected String id;
	protected String name;
	protected String description;
	protected Periodicity periodicity;
	protected User user;
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public ArrayList<Event> generateRepeats()
	{
		return null;
	}
}
