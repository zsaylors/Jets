package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	private AirField airField;
	//AirField airField = new AirField(null);
	
	Scanner kb = new Scanner(System.in);
	AirField a = new AirField(null);
	
	public static void main(String[] args) {
		JetsApplication j = new JetsApplication();
		//Jets h = new Jets();
		//AirField a = new AirField(null);
		//System.out.println(a.getJetList())
		//System.out.println(a.createJetList());
		//System.out.println(a.createJetList().get(0)[0]);
		j.launch();
		//kb.close();
	}

	private void launch() {
		System.out.println(a.getJetList());
		displayUderMenu(kb);
	}
	
	private void displayUderMenu(Scanner kb) {
		boolean run = true;
		while(run) {
			printedMenu();
			String userChoice = kb.nextLine();
			
			switch(userChoice) {
			case "1":
				System.out.println(a.getJetList());
				break;
			case "2":
				break;
			case "3":
				//a.fastestJet2(a.listJetFleet());
				//a.fastestJet();
				break;
			case "4":
				System.out.println("placeholder");
				break;
			case "5":
				System.out.println("placeholder");
				break;
			case "6":
				System.out.println("placeholder");
				break;
			case "7":
				System.out.println("placeholder");
				break;
			case "8":
				System.out.println("placeholder");
				break;
			case "9":
				run = false;
				break;
			default:
				System.out.println("That is an invalid entry.  Enter a value 1 - 9.");
				break;
			}
			
		}
	}

	private void printedMenu() {
		StringBuilder menu = new StringBuilder("____________________\n"  
											 + "1.  List Fleet\n"  
											 + "2.  Fly All Jets\n"  
											 + "3.  View Fastest Jet\n"  
											 + "4.  View Jet With Longest Range\n"  
											 + "5.  Load all Cargo Jets\n"  
											 + "6.  Dogfight!\n"  
											 + "7.  Add a Jet To Fleet\n"  
											 + "8.  Remove a Jet From Fleet\n"
											 + "9.  Quit");	
		System.out.println(menu);
	}
//	
//	public void flyAllJets() {
//	}
//	
//	public void fastestJet() {
//	}
//	
//	public void longestRange() {
//	}
//	
//	public void dogFight() {
//	}
//	
//	public void addJet() {
//	}
//	
//	public void allCargoJets() {
//	}
//
//	public void removeJet() {
//	}
}