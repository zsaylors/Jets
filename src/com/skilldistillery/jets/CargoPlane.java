package com.skilldistillery.jets;

public class CargoPlane extends Jet {

	public CargoPlane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargoPlane(String model, double speed, int range, int price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		 return getModel() + " " + getSpeed() + " " + getRange() + " " + getPrice() ;
	}
}
