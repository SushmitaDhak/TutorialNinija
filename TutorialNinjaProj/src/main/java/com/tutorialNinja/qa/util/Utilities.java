package com.tutorialNinja.qa.util;

import java.util.Date;

   
public class Utilities {
	public static final int  IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;
	
	public static String generateEmailWithTimeStamp(){
		Date date = new Date ();
		String timestamp =  date.toString().replace(" ", "_").replace(":", "_");
		return "sushmita01dh"+timestamp+"@gmail.com";
	}
	
		

	

}
