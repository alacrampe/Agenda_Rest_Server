
package fr.ingesup.agenda.ws.models;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

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
					Period m=new Period();
					m.setName(this.name);
					m.setDescription(this.description);
					
					
					
					m.getDateBegin().setYear(this.getDateBegin().getYear()+i);
					m.getDateEnd().setYear(this.getDateEnd().getYear()+i);
					
					m.getDateBegin().setMonth(d.getMonth());
					m.getDateEnd().setDay(d.getDay());
					
					repeats.add(m);
				}
			}
			else if(periodicity.getType()==Periodicity.Type.MONTHDAY)
			{
				for(Integer ints : periodicity.getMonthDays())
				{
					Period m=new Period();
					m.setName(this.name);
					m.setDescription(this.description);
					
					
					LocalDate pb2=new LocalDate(this.getDateBegin().getYear(), this.getDateBegin().getMonth(), ints);
					pb2.plusMonths(1);
					LocalDate pe2=new LocalDate(this.getDateEnd().getYear(), this.getDateEnd().getMonth(), ints);
					pe2.plusMonths(1);
					
					m.getDateBegin().setYear(pb2.getYear());
					m.getDateBegin().setMonth(pb2.getMonthOfYear());
					
					m.getDateEnd().setYear(pe2.getYear());
					m.getDateEnd().setMonth(pe2.getMonthOfYear());
					
					repeats.add(m);
				}
			}
			else if(periodicity.getType()==Periodicity.Type.WEEKDAY)
			{
				for(Integer ints : periodicity.getWeekDays())
				{
					Period m=new Period();
					m.setName(this.name);
					m.setDescription(this.description);
					
					
					LocalDate pb2=new LocalDate(this.getDateBegin().getYear(), this.getDateBegin().getMonth(), this.getDateBegin().getDay());
					pb2.plusDays(7);
					LocalDate pe2=new LocalDate(this.getDateEnd().getYear(), this.getDateEnd().getMonth(), this.getDateEnd().getDay());
					pe2.plusDays(7);
					
					m.getDateBegin().setYear(pb2.getYear());
					m.getDateBegin().setMonth(pb2.getMonthOfYear());
					
					m.getDateEnd().setYear(pe2.getYear());
					m.getDateEnd().setMonth(pe2.getMonthOfYear());
					
					repeats.add(m);
				}
			}
			else if(periodicity.getType()==Periodicity.Type.SPECIALDAY)
			{
				
				List<ComplexPeriodicity> lcp=this.getPeriodicity().getSpecialDays();
				for(ComplexPeriodicity cp : lcp)
				{
					Period m=new Period();
					m.setName(this.name);
					m.setDescription(this.description);
					
					
					LocalDate date=new LocalDate(this.getDateBegin().getYear()+i, cp.getMonth(), 1);
					LocalDate date2=date.withDayOfWeek(cp.getDay());
					if(date2.isBefore(date))
					{
						date2.plusWeeks(cp.getNumberInMonth());
					}
					else {
						date2.plusWeeks(cp.getNumberInMonth()-1);
					}
					m.getDateBegin().setYear(date2.getYear());
					m.getDateBegin().setMonth(date2.getMonthOfYear());
					m.getDateBegin().setYear(date2.getDayOfMonth());
					
					m.getDateEnd().setYear(date2.getYear());
					m.getDateEnd().setMonth(date2.getMonthOfYear());
					m.getDateEnd().setYear(date2.getDayOfMonth());
					
					repeats.add(m);
				}

			}

		}
		return repeats;
	}
}
