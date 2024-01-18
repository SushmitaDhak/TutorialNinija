package com.sush;

public class MobilePhone implements Telephone{
	private String myNumber;
	private boolean isRinging;
	private boolean isPowerOn;
	public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
		
	}
	@Override
	public void powerOn() {
		isPowerOn = true;
		System.out.println("Phone powered on");
		
	}
	@Override
	public void dial(String phoneNumber) {
		System.out.println("Now Ringing "+phoneNumber+"on deskphone");
		
	}
	@Override
	public void answer() {
		if(isRinging && isPowerOn) {
			System.out.println("Answering the desk phone");
			isRinging=false;
		}
		else {
			System.out.println("Phone is not Ringing");
		}
		
	}
	@Override
	public boolean callPhone(String phoneNumber) {
		if (phoneNumber.equals(phoneNumber) && isPowerOn) {
			isRinging=true;
			System.out.println("Phone Ringing");
		}
		else {
			System.out.println("Either Wrong Number Entered Or Phone is Off");
			isRinging = false;
		}
		return isRinging;
	}
	@Override
	public boolean isRinging() {
		
		return isRinging;
	}

}
