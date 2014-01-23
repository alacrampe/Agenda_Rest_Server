package fr.ingesup.agenda.ws.serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fr.ingesup.agenda.ws.models.Event;

public class EventSerializer {
	
	public static ArrayList<Event> events;
	
	public static ArrayList<Event> getAll()
	{
		return events;
	}
	
	public static Event getEvent(String id)
	{
		if(events!=null)
		{
			Event event=null;
			boolean found=false;
			int i=0;
			
			while(!found)
			{
				event=events.get(i);
				if(event.getId()==id)
				{
					found=true;
				}
			}
			return(event);
		}
		else
		{
			return null;
		}
	}
	
	public static void addEvent(Event ev)
	{
		if(events!=null)
		{
			if(events.size()<=0)
			{
				Event ev2=events.get(events.size()-1);
				ev.setId(""+Integer.parseInt(ev2.getId())+1);
			}
			else
			{
				ev.setId("1");
			}
			events.add(ev);
		}
		
		
	}
	public static void replaceEvent(Event former, Event newer)
	{
		if(events!=null)
		{
			int i=events.indexOf(former);
			events.set(i, newer);
		}
	}
	public static void removeEvent(Event ev)
	{
		if(events!=null)
		{
			events.remove(ev);
		}
	}
	
	public static void Load()
	{
		try{
			FileInputStream fis=new FileInputStream("events.ser");
			ObjectInputStream ois=new ObjectInputStream(fis);
			events=(ArrayList<Event>) ois.readObject();
			ois.close();
			fis.close();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void Save()
	{
		try{
			FileOutputStream fos=new FileOutputStream("events.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(events);
			oos.close();
			fos.close();
		}
		catch(Exception ex)
		{
			
		}
	}
}
