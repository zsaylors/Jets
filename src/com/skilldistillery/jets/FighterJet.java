package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {
	//F I E L D S
	
	//C O N S T R U C T O R S
	public FighterJet() {
		super();
	}

	public FighterJet(String model, double speed, int range, int price) {
		super(model, speed, range, price);
	}
	
	//M E T H O D S
	public void fight() {
		System.out.println(": No dog fighting while in continental US.\n\t\t. . ."
				+ "Maybe draw something in the sky instead?");
	}
}
