package fr.ingesup.agenda.ws.models;

import java.util.List;

public class Periodicity {
	private String id;
	private Type type;
	private List<Integer> weekDays;
	private List<Integer> monthDays;
	private List<Date> yearDays;
	private List<ComplexPeriodicity> specialDays;
	private int repeat;
	
	public enum Type {
		WEEKDAY, MONTHDAY, YEARDAY, SPECIALDAY
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Integer> getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(List<Integer> weekDays) {
		this.weekDays = weekDays;
	}

	public List<Integer> getMonthDays() {
		return monthDays;
	}

	public void setMonthDays(List<Integer> monthDays) {
		this.monthDays = monthDays;
	}

	public List<Date> getYearDays() {
		return yearDays;
	}

	public void setYearDays(List<Date> yearDays) {
		this.yearDays = yearDays;
	}

	public List<ComplexPeriodicity> getSpecialDays() {
		return specialDays;
	}

	public void setSpecialDays(List<ComplexPeriodicity> specialDays) {
		this.specialDays = specialDays;
	}

	public int getRepeat() {
		return repeat;
	}

	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}
}
