package fr.ingesup.agenda.ws.serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fr.ingesup.agenda.ws.models.Event;

public class EventSerializer {
	
	public static ArrayList<Event> events=new ArrayList<Event>();
	
	public static ArrayList<Event> getAll()
	{
		return events;
	}
	
	public static void addEvent(Event ev)
	{
		events.add(ev);
		
	}
	public static void removeEvent(Event ev)
	{
		events.remove(ev);
	}
	
	public static void Load()
	{
		try{
			FileInputStream fis=new FileInputStream("");
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
			FileOutputStream fos=new FileOutputStream("");
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
