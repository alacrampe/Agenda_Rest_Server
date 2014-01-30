
package fr.ingesup.agenda.ws.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class Meeting extends Event {

	public Meeting() {
		this.type = Type.M;
	}
	
	private PointInTime pointBegin;
	private PointInTime pointEnd;
	private List<String> participants;
	
	public PointInTime getPointBegin() {
		return pointBegin;
	}
	public void setPointBegin(PointInTime pointBegin) {
		this.pointBegin = pointBegin;
	}
	public PointInTime getPointEnd() {
		return pointEnd;
	}
	public void setPointEnd(PointInTime pointEnd) {
		this.pointEnd = pointEnd;
	}
	public List<String> getParticipants() {
		return participants;
	}
	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}
	
	public ArrayList<Event> generateRepeats()
	{
		ArrayList<Event> repeats=new ArrayList<Event>();
		repeats.add(this);
		for(int i=0; i<periodicity.getRepeat(); i++)
		{

			if(periodicity.getType()==Periodicity.Type.YEARDAY)
			{
				for(Date d : periodicity.getYearDays())
				{
					Meeting m=new Meeting();
					m.setName(this.name);
					m.setDescription(this.description);
					m.setParticipants(this.getParticipants());
					
					
					m.getPointBegin().getDate().setYear(this.getPointBegin().getDate().getYear()+i);
					m.getPointEnd().getDate().setYear(this.getPointEnd().getDate().getYear()+i);
					
					m.getPointBegin().getDate().setMonth(d.getMonth());
					m.getPointEnd().getDate().setDay(d.getDay());
					
					repeats.add(m);
				}
			}
			else if(periodicity.getType()==Periodicity.Type.MONTHDAY)
			{
				for(Integer ints : periodicity.getMonthDays())
				{
					Meeting m=new Meeting();
					m.setName(this.name);
					m.setDescription(this.description);
					m.setParticipants(this.getParticipants());
					
					LocalDate pb2=new LocalDate(this.getPointBegin().getDate().getYear(), this.getPointBegin().getDate().getMonth(), ints);
					pb2.plusMonths(1);
					LocalDate pe2=new LocalDate(this.getPointEnd().getDate().getYear(), this.getPointEnd().getDate().getMonth(), ints);
					pe2.plusMonths(1);
					
					m.getPointBegin().getDate().setYear(pb2.getYear());
					m.getPointBegin().getDate().setMonth(pb2.getMonthOfYear());
					
					m.getPointEnd().getDate().setYear(pe2.getYear());
					m.getPointEnd().getDate().setMonth(pe2.getMonthOfYear());
					
					repeats.add(m);
				}
			}
			else if(periodicity.getType()==Periodicity.Type.WEEKDAY)
			{
				for(Integer ints : periodicity.getWeekDays())
				{
					Meeting m=new Meeting();
					m.setName(this.name);
					m.setDescription(this.description);
					m.setParticipants(this.getParticipants());
					
					LocalDate pb2=new LocalDate(this.getPointBegin().getDate().getYear(), this.getPointBegin().getDate().getMonth(), this.getPointBegin().getDate().getDay());
					pb2.plusDays(7);
					LocalDate pe2=new LocalDate(this.getPointEnd().getDate().getYear(), this.getPointEnd().getDate().getMonth(), this.getPointEnd().getDate().getDay());
					pe2.plusDays(7);
					
					m.getPointBegin().getDate().setYear(pb2.getYear());
					m.getPointBegin().getDate().setMonth(pb2.getMonthOfYear());
					
					m.getPointEnd().getDate().setYear(pe2.getYear());
					m.getPointEnd().getDate().setMonth(pe2.getMonthOfYear());
					
					repeats.add(m);
				}
			}
			else if(periodicity.getType()==Periodicity.Type.SPECIALDAY)
			{
				
				List<ComplexPeriodicity> lcp=this.getPeriodicity().getSpecialDays();
				for(ComplexPeriodicity cp : lcp)
				{
					Meeting m=new Meeting();
					m.setName(this.name);
					m.setDescription(this.description);
					m.setParticipants(this.getParticipants());
					
					LocalDate date=new LocalDate(this.getPointBegin().getDate().getYear()+i, cp.getMonth(), 1);
					LocalDate date2=date.withDayOfWeek(cp.getDay());
					if(date2.isBefore(date))
					{
						date2.plusWeeks(cp.getNumberInMonth());
					}
					else {
						date2.plusWeeks(cp.getNumberInMonth()-1);
					}
					m.getPointBegin().getDate().setYear(date2.getYear());
					m.getPointBegin().getDate().setMonth(date2.getMonthOfYear());
					m.getPointBegin().getDate().setYear(date2.getDayOfMonth());
					
					m.getPointEnd().getDate().setYear(date2.getYear());
					m.getPointEnd().getDate().setMonth(date2.getMonthOfYear());
					m.getPointEnd().getDate().setYear(date2.getDayOfMonth());
					
					repeats.add(m);
				}

			}

		}
		return repeats;
	}
	
}

