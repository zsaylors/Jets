package com.skilldistillery.jets;

public class Jets extends Jet {

	public Jets() {
		super();
	}

	public Jets(String model, double speed, int range, int price) {
		super(model, speed, range, price);
	}
	
	public String toString() {
		 return this.getModel() + " " + getSpeed() + " " + getRange() + " " + getPrice() ;
	}
}
