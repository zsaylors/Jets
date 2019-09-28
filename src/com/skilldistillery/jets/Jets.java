package com.skilldistillery.jets;

public class Jets extends Jet implements CombatReady {

	public Jets() {
		super();
	}

	public Jets(String model, double speed, int range, int price) {
		super(model, speed, range, price);
	}
	
	public String toString() {
		StringBuilder p = new StringBuilder("Model: " + getModel() + "  --  Speed: " + getSpeed() +
										"  --  Range: " + getRange() + "  --  Price: " + getPrice() );
		return p.toString();
	}
	
	public void fight() {
		System.out.println(" It's 2019. Good luck with that dogfight happening!");
	}
}
