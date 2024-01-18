package com.pizza;

public class Pizza {
	private int price;
	private boolean veg;
	private int extraCheesePrice = 100;
	private int extraToppingsPrice = 150;
	private int backPackPrice = 20;
	private int basePizzaPrice;
	private boolean isExtraCheeseAdded = false;
	private boolean isExtraToppingsAdded = false ;
	private boolean isOptedForTakeAway= false;
	public Pizza( boolean veg) {
		super();
		this.veg = veg;
		if(this.veg) {
			this.price=300;
		}
		else {
			this.price=400;
		}
		basePizzaPrice = this.price;
	}
	public void addExtraCheese() {
		isExtraCheeseAdded = true;
		System.out.println("Extra Cheese Added");
		this.price+=extraCheesePrice;
		
	}
	public void addExtraToppings() {
		isExtraToppingsAdded = true;
		System.out.println("Add ExtraToppings");
		this.price+=extraToppingsPrice;
		
	}
	public void takeAway() {
		isOptedForTakeAway= true;
		System.out.println("Take Away Opted");
		this.price+=backPackPrice;
		
		
	}
	public void getBill() {
		String bill =" ";
		System.out.println("Pizza : "+basePizzaPrice );
		if(isExtraCheeseAdded) {
			bill+= "Extra Cheese Added:  "+ extraCheesePrice+"\n";
		}
		if(isExtraToppingsAdded) {
			bill+= "Extra Toppinga Added:  "+ extraToppingsPrice+"\n";
		}if(isOptedForTakeAway) {
			bill+= "Take Away  "+ backPackPrice+"\n";
		}
		bill+="Bill: "+this.price+"\n";
		System.out.println(bill);
	
	/** Base pizza : 300
	 * Toppings : 150 
	 * Cheese : 100
	 * Take away : 20
	 */
	}

}
