package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	//F I E L D S
	private List<Jet> jetList = new ArrayList<>();
	private Scanner kb = new Scanner(System.in);
	
	//C O N S T R U C T O R S
	public AirField(List<Jet> jetList) {
		this.jetList = createJetList();
	}

	//M E T H O D S
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
					jetList.add(new Jets(model, speed, range, price));
				} else if (newJet[0].equalsIgnoreCase("Cargo")) {
					jetList.add(new CargoPlane(model, speed, range, price));
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

	// M E N U   I T E M S
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
	
	// MENU OPTION 4
	public void longestRange() {
		int longestRange = 0;
		String rangeJet = "";
		for (int i = 0; i < jetList.size(); i++) {
			if (longestRange < jetList.get(i).getRange()) {
				longestRange = jetList.get(i).getRange();
				rangeJet = jetList.get(i).toString();
			}
		}
		System.out.println("Jet with longest range in inventory:\n" + rangeJet);
	}
	
	// MENU OPTION 5
	public void addCargo() {
		for (int i = 0; i < jetList.size(); i++) {
			if (jetList.get(i) instanceof CargoPlane) {
				System.out.print(jetList.get(i).getModel() + " ");
				((CargoPlane) jetList.get(i)).loadCargo();
			}
		}
	}
	
	// MENU OPTION 6
	public void dogFight() {
		for (int i = 0; i < jetList.size(); i++) {
			if (jetList.get(i) instanceof Jets) {
				System.out.print(jetList.get(i).getModel() + " ");
				((Jets) jetList.get(i)).fight();
			}
		}
	}
	
	// MENU ITEM 7
	public void addJet() {
		System.out.println("What type of plane would you like to add?\n1.Fighter\n2.Cargo");
		String jetChoice = kb.nextLine();
		System.out.print("Enter model: ");
		String model = kb.next();
		System.out.print("Enter speed: ");
		double speed = kb.nextDouble();
		System.out.print("Enter range: ");
		int range = kb.nextInt();
		System.out.print("Enter price: ");
		int price = kb.nextInt();
		
		switch(jetChoice) {
			case "Fighter":
			case "fighter":
			case "1":
				jetList.add(new Jets(model, speed, range, price));
				break;
			case "Cargo":
			case "cargo":
			case "2":
				jetList.add(new Jets(model, speed, range, price));
				break;
			default:
				System.out.println("Invalid choice.");
		}	
	}
	
	// MENU ITEM 8
	public void deleteJet() {
		System.out.println("Select a jet to delete: ");
		for (int i = 0; i < jetList.size(); i++) {
			System.out.println((i + 1) + ". "+ jetList.get(i).getModel());	
		}
		int deleteInput = kb.nextInt();
		System.out.println(jetList.get(deleteInput - 1) + " has been removed.");
		jetList.remove(deleteInput - 1);
	}	
}