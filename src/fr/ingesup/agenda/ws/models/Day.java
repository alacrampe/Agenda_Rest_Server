package fr.ingesup.agenda.ws.models;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public class Day extends Event {
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
					Day m=new Day();
					m.setName(this.name);
					m.setDescription(this.description);
					
					m.getDate().setYear(this.getDate().getYear()+i);
					
					m.getDate().setMonth(d.getMonth());
					
					repeats.add(m);
				}
			}
			else if(periodicity.getType()==Periodicity.Type.MONTHDAY)
			{
				for(Integer ints : periodicity.getMonthDays())
				{
					Day m=new Day();
					m.setName(this.name);
					m.setDescription(this.description);
					
					
					LocalDate pb2=new LocalDate(this.getDate().getYear(), this.getDate().getMonth(), ints);
					pb2.plusMonths(1);
										
					m.getDate().setYear(pb2.getYear());
					m.getDate().setMonth(pb2.getMonthOfYear());

					repeats.add(m);
				}
			}
			else if(periodicity.getType()==Periodicity.Type.WEEKDAY)
			{
				for(Integer ints : periodicity.getWeekDays())
				{
					Day m=new Day();
					m.setName(this.name);
					m.setDescription(this.description);
					
					
					LocalDate pb2=new LocalDate(this.getDate().getYear(), this.getDate().getMonth(), this.getDate().getDay());
					pb2.plusDays(7);

					m.getDate().setYear(pb2.getYear());
					m.getDate().setMonth(pb2.getMonthOfYear());

					repeats.add(m);
				}
			}
			else if(periodicity.getType()==Periodicity.Type.SPECIALDAY)
			{
				
				List<ComplexPeriodicity> lcp=this.getPeriodicity().getSpecialDays();
				for(ComplexPeriodicity cp : lcp)
				{
					Day m=new Day();
					m.setName(this.name);
					m.setDescription(this.description);
					
					
					LocalDate date=new LocalDate(this.getDate().getYear()+i, cp.getMonth(), 1);
					LocalDate date2=date.withDayOfWeek(cp.getDay());
					if(date2.isBefore(date))
					{
						date2.plusWeeks(cp.getNumberInMonth());
					}
					else {
						date2.plusWeeks(cp.getNumberInMonth()-1);
					}
					m.getDate().setYear(date2.getYear());
					m.getDate().setMonth(date2.getMonthOfYear());
					m.getDate().setYear(date2.getDayOfMonth());

					repeats.add(m);
				}

			}

		}
		return repeats;
	}
}
