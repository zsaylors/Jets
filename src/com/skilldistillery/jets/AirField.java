package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	// F I E L D S
	private List<Jet> jetList = new ArrayList<>();
	private Scanner kb = new Scanner(System.in);

	// C O N S T R U C T O R S
	public AirField(List<Jet> jetList) {
		this.jetList = createJetList();
	}

	// M E T H O D S
	public List<Jet> getJetList() {
		return jetList;
	}

	public void setJetList(List<Jet> jetList) {
		this.jetList = jetList;
	}

	// Returns jet list from the file jets.txt
	public List<Jet> createJetList() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("jets.txt"));
			String name;
			String[] newJet = null;

			while ((name = br.readLine()) != null) {
				newJet = name.split(", ");
				String model = newJet[1];
				double speed = Double.parseDouble(newJet[2]);
				int range = Integer.parseInt(newJet[3]);
				int price = Integer.parseInt(newJet[4]);

				if (newJet[0].equalsIgnoreCase("Fighter")) {
					jetList.add(new FighterJet(model, speed, range, price));
				} else if (newJet[0].equalsIgnoreCase("Cargo")) {
					jetList.add(new CargoPlane(model, speed, range, price));
				} else if (newJet[0].equalsIgnoreCase("Trainer")) {
					jetList.add(new Trainer(model, speed, range, price));
				} else {
					jetList.add(new JetImpl(model, speed, range, price));
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jetList;
	}

	// M E N U I T E M S
	// MENU OPTION 1
	public void listFleet() {
		for (int i = 0; i < jetList.size(); i++) {
			System.out.println(jetList.get(i).toString());
		}
	}

	// MENU OPTION 2
	public void flyAll() {
		for (int i = 0; i < jetList.size(); i++) {
			jetList.get(i).fly();
		}
	}

	// MENU OPTION 3
	public void flySingle() {
		if (jetList.size() != 0) {
			System.out.println("Select a jet to fly: ");
			for (int i = 0; i < jetList.size(); i++) {
				System.out.println((i + 1) + ". " + jetList.get(i).getModel());
			}
			try {
				int flyInput = kb.nextInt();
				jetList.get(flyInput - 1).fly();
			} catch (Exception e) {
				System.out.println("Invlaid entry.  Try again.");
			}
			kb.nextLine();
		}
	}

	// MENU OPTION 4
	public void fastestJet() {
		double fastest = 0;
		String fastestJet = "";
		for (int i = 0; i < jetList.size(); i++) {
			if (fastest < jetList.get(i).getSpeed()) {
				fastest = jetList.get(i).getSpeed();
				fastestJet = jetList.get(i).toString();
			}
		}
		System.out.println("Fastest jet in inventory:\n" + fastestJet);
	}

	// MENU OPTION 5
	public void longestRange() {
		int longestRange = 0;
		String rangeJet = "";
		for (int i = 0; i < jetList.size(); i++) {
			if (longestRange < jetList.get(i).getRange()) {
				longestRange = jetList.get(i).getRange();
				rangeJet = jetList.get(i).toString();
			}
		}
		System.out.println("Plane with longest range in inventory is:\n" + rangeJet);
	}

	// MENU OPTION 6
	public void addCargo() {
		String printOut = "";
		for (int i = 0; i < jetList.size(); i++) {
			if (jetList.get(i) instanceof CargoPlane) {
				printOut = (jetList.get(i).getModel() + " ");
				System.out.println(printOut);
				((CargoPlane) jetList.get(i)).loadCargo();
			}
		}
		if (printOut.contentEquals("")) {
			System.out.println("There are no cargo planes in the inventory!\nConsider adding one with with option 9.");
		}
	}

	// MENU OPTION 7
	public void dogFight() {
		String printOut = "";
		for (int i = 0; i < jetList.size(); i++) {
			if (jetList.get(i) instanceof FighterJet) {
				printOut = (jetList.get(i).getModel() + " ");
				System.out.println(printOut);
				((FighterJet) jetList.get(i)).fight();
			}
		}
		if (printOut.contentEquals("")) {
			System.out.println("There are no fighter jets in the inventory!\nConsider adding one with with option 9.");
		}
	}

	// MENU OPTION 8
	public void train() {
		for (int i = 0; i < jetList.size(); i++) {
			if (jetList.get(i) instanceof Trainer) {
				boolean doTrain = true;
				while (doTrain) {
					trainMenu();
					String trainNum = kb.next();
					switch (trainNum) {
					case "1":
						((Trainer) jetList.get(i)).touchAndGoes();
						break;
					case "2":
						((Trainer) jetList.get(i)).radioComms();
						break;
					case "3":
						((Trainer) jetList.get(i)).stall();
						break;
					case "4":
						((Trainer) jetList.get(i)).spin();
						break;
					case "5":
						((Trainer) jetList.get(i)).loop();
						break;
					case "6":
						((Trainer) jetList.get(i)).barrelRoll();
						break;
					case "7":
						doTrain = false;
						break;
					default:
						System.out.println("Invalid entry.");
						break;
					}
				}
				break;
			}
		}
	}

	// MENU OPTION 8 MENU:
	private void trainMenu() {
		System.out.println("\nWhat would you like to train?\n" + "1.  Touch and Goes\n" + "2.  Radio Calls\n"
				+ "3.  Stalls\n" + "4.  Spins\n" + "5.  Loops\n" + "6.  Barrel Rolls\n" + "7.  Quit\n");
	}

	// MENU OPTION 9
	public void addJet() {
		System.out
				.println("What type of plane would you like to add?\n1. Fighter\n2. Cargo\n3." + " Trainer\n4. Other");
		String jetChoice = kb.nextLine();
		System.out.print("Enter model: ");
		String model = kb.next();
		System.out.print("Enter speed: ");
		double speed = kb.nextDouble();
		System.out.print("Enter range: ");
		int range = kb.nextInt();
		System.out.print("Enter price: ");
		int price = kb.nextInt();
		kb.nextLine();

		switch (jetChoice) {
		case "Fighter":
		case "fighter":
		case "1":
			jetList.add(new FighterJet(model, speed, range, price));
			break;
		case "Cargo":
		case "cargo":
		case "2":
			jetList.add(new FighterJet(model, speed, range, price));
			break;
		case "Trainer":
		case "trainer":
		case "3":
			jetList.add(new Trainer(model, speed, range, price));
			break;
		case "Other":
		case "other":
		case "4":
			jetList.add(new JetImpl(model, speed, range, price));
			break;
		default:
			System.out.println("Invalid choice.");
		}
	}

	// MENU OPTION 10
	public void deleteJet() {
		if (jetList.size() != 0) {
			System.out.println("Select a jet to delete: ");
			for (int i = 0; i < jetList.size(); i++) {
				System.out.println((i + 1) + ". " + jetList.get(i).getModel());
			}
			try {
				int deleteInput = kb.nextInt();
				System.out.println(jetList.get(deleteInput - 1).getModel() + " has been removed.");
				jetList.remove(deleteInput - 1);
			} catch (Exception e) {
				System.out.println("Invlaid entry.  Try again.");
			}
			kb.nextLine();
		}
	}

	// Gives message if a "list" option or "delete" option is picked when no planes
	// are in inventory.
	public void noPlanes() {
		if (jetList.size() == 0) {
			System.out.println("There are no planes in the inventory.\nConsider adding some with with option 9.");
		}
	}
}