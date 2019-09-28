package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {
	//F I E L D S
	
	//C O N S T R U C T O R S
	public CargoPlane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargoPlane(String model, double speed, int range, int price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	//M E T H O D S
	@Override
	public void loadCargo() {
		System.out.println("Cargo loaded!");
	}
}
