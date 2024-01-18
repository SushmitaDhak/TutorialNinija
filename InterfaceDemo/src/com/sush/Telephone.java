package com.sush;

public interface Telephone {
	// Power on OR Off
	// dial Number
	// answer phone call
	// call another phone
	// is phone ringing or not
	void powerOn() ;
	void dial (String phoneNumber);
	void answer();
	boolean callPhone(String phoneNumber);
	boolean isRinging();
	
	
	
	

}
