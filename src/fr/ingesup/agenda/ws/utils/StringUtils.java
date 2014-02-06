package fr.ingesup.agenda.ws.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {
	public final static boolean isNotEmpty(String theString)
	{
		return (theString != null && !theString.isEmpty());
	}
	
	public final static boolean isNotNull(String theString)
	{
		return theString != null;
	}
	
	public final static boolean isNullOrEmpty(String theString)
	{
		return theString == null || theString.isEmpty();
	}
	
	public static String MD5Hash(String toHash) throws RuntimeException {
	   try{
	       return String.format("%032x", // produces lower case 32 char wide hexa left-padded with 0
	      new BigInteger(1, // handles large POSITIVE numbers 
	           MessageDigest.getInstance("MD5").digest(toHash.getBytes())));
	   }
	   catch (NoSuchAlgorithmException e) {
	      // do whatever seems relevant
	   }
	   return null;
	}
}
