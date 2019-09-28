package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargoPlane(String model, double speed, int range, int price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		StringBuilder p = new StringBuilder("Model: " + getModel() + "  --  Speed: " + getSpeed() +
										"  --  Range: " + getRange() + "  --  Price: " + getPrice() );
		return p.toString();
	}

	@Override
	public void loadCargo() {
		System.out.println("Cargo loaded!");
	}
}
