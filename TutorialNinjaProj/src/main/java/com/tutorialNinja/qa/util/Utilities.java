package com.tutorialNinja.qa.util;

import java.util.Date;

   
public class Utilities {
	public static String generateEmailWithTimeStamp(){
		Date date = new Date ();
		String timestamp =  date.toString().replace(" ", "_").replace(":", "_");
		return "sushmita01dh"+timestamp+"@gmail.com";
	}
	
		

	

}
