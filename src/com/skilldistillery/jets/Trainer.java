package com.skilldistillery.jets;

public class Trainer extends Jet implements Train {
	//F I E L D S
	
	//C O N S T R U C T O R S
	public Trainer() {
		
	}
	
	public Trainer(String model, double speed, int range, int price) {
		super(model, speed, range, price);
	}
	
	//M E T H O D S
	@Override
	public void touchAndGoes() {
		int goodManueverChance = (int) (Math.random()*100);
		String[] TaG = {"Greased in!", "Ok landing.", "Wave off!!"};
		
		if (goodManueverChance < 20) {
			System.out.println(TaG[0]);
		} else if (goodManueverChance < 60) {
			System.out.println(TaG[1]);
		} else {
			System.out.println(TaG[2]);
		}
	}

	@Override
	public void radioComms() {
		System.out.println("atc: ASD?aljsdalskdnsda\n"
				+ "pilot: Come again?!\n"
				+ "atc: RAdaklmndlaknConTASD\n"
				+ "pilot: Come again\n"
				+ "atc: RadsaR CpasjTact\n"
				+ "pilot: Come again??\n"
				+ "atc: Radar Contact\n\n"
				+ "\t. . . Maybe work on those comms . . . ");
	}

	@Override
	public void stall() {
		int goodManueverChance = (int) (Math.random()*100);
		String[] stall = {"Good stall!", "Meh"};
		
		if (goodManueverChance < 70) {
			System.out.println(stall[0]);
		} else {
			System.out.println(stall[1]);
		}
	}

	@Override
	public void spin() {
		int goodManueverChance = (int) (Math.random()*100);
		String[] spin = {"Good Spin!", "Instructor: I have the controls!!!"};

		if (goodManueverChance < 60) {
			System.out.println(spin[0]);
		} else {
			System.out.println(spin[1]);
		}
	}

	@Override
	public void loop() {
		int goodManueverChance = (int) (Math.random()*100);
		String[] loop = {"Great", "A little too slow at the top..."};
		
		if (goodManueverChance < 60) {
			System.out.printf("%.2f G's pulled%n", 3 + (Math.random()*2));
			System.out.println(loop[0]);
		} else {
			System.out.printf("%.2f G's pulled%n", 2.5 + (Math.random()));
			System.out.println(loop[1]);
		}
	}

	@Override
	public void barrelRoll() {
		int goodManueverChance = (int) (Math.random()*100);
		String[] bRoll = {"Good!", "It's supposed to be a smooth manuever!"};
		
		if (goodManueverChance < 30) {
			System.out.printf("%.2f G's pulled%n", 2.3 + (Math.random()));
			System.out.println(bRoll[0]);
		} else {
			System.out.printf("%.2f G's pulled%n", 3.5 + (Math.random()));
			System.out.println(bRoll[1]);
		}
	}
}
