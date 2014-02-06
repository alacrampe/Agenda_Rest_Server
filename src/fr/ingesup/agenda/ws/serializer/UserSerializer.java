package fr.ingesup.agenda.ws.serializer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fr.ingesup.agenda.ws.models.User;
import fr.ingesup.agenda.ws.utils.Log;

public class UserSerializer {
	
	public static ArrayList<User> users;
	
	public static ArrayList<User> getAll()
	{
		initIfNull();
		return users;
	}
	
	public static User getUser(String id)
	{
		initIfNull();
		User user=null;
		int i=0;
		
		while(user == null && i<users.size())
		{
			if(users.get(i).getId().equals(id)) {
				user = users.get(i);
			}
		}
		return(user);
	}
	public static User getUserByToken(String token)
	{
		initIfNull();
		User user=null;
		boolean found=false;
		int i=0;
		
		while(!found && i<users.size())
		{
			user=users.get(i);
			if(user.getUserToken()==token)
			{
				found=true;
			}
			i++;
		}
		return(user);
		
		
	}
	
	public static String addUser(User ev)
	{
		initIfNull();
		if(users == null) {
			Load();
		}
		if(users.size()>0)
		{
			User ev2=users.get(users.size()-1);
			ev.setId(""+(Integer.parseInt(ev2.getId())+1));
		}
		else
		{
			ev.setId("1");
		}
		users.add(ev);
		Save();
		return ev.getId();
	}
	public static User replaceUser(User former, User newer)
	{
		initIfNull();
		
		int i=users.indexOf(former);
		users.set(i, newer);
		Save();
		return newer;
	}
	public static void removeUser(User ev)
	{
		initIfNull();
		users.remove(ev);
		Save();
	}
	
	public static void initIfNull()
	{
		if(users==null)
		{
			Load();
		}
	}
	
	public static void Load()
	{
		try{
			FileInputStream fis=new FileInputStream("users.ser");
			ObjectInputStream ois=new ObjectInputStream(fis);
			users=(ArrayList<User>) ois.readObject();
			ois.close();
			fis.close();
			if(users==null)
			{
				users=new ArrayList<User>();
			}
		}
		catch(FileNotFoundException e)
		{
			Log.error(e);
			users=new ArrayList<User>();
			Save();
			Load();
		} catch (IOException e) {
			Log.error(e);
		} catch (ClassNotFoundException e) {
			Log.error(e);
		}
	}
	
	public static void Save()
	{
		try{
			FileOutputStream fos=new FileOutputStream("users.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
			fos.close();
		}
		catch(Exception ex)
		{
			Log.error(ex);
		}
	}
}
