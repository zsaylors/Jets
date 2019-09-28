//Must do's:
//Clean up text file
//Change messages for delete to just say model

//Additional Objectives if time permits later:
//1.  Look into if there are any stretch goals I want to implement.
//2.  Consider adding extra features or a user story.
//3.  Clean up jet list to make it a little more realistic or fun (to go with user story).
//4.  Maybe add some Unicode.
//5.  Try switching for loops to for each loops for practice.
//6.  Add exceptions to prevent code from breaking
//7.  Add a new plane type such as helos.

package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	//private AirField airField;	
	Scanner kb = new Scanner(System.in);
	private AirField airField = new AirField(null);
	
	public static void main(String[] args) {
		JetsApplication j = new JetsApplication();
		j.launch();
	}

	private void launch() {
		displayUderMenu(kb);
	}
	
	private void displayUderMenu(Scanner kb) {
		boolean run = true;
		while(run) {
			printedMenu();
			String userChoice = kb.nextLine();
			
			switch(userChoice) {
			case "1":
				airField.listFleet();
				break;
			case "2":
				airField.flyAll();
				break;
			case "3":
				airField.fastestJet();
				break;
			case "4":
				airField.longestRange();
				break;
			case "5":
				airField.addCargo();
				break;
			case "6":
				airField.dogFight();
				break;
			case "7":
				airField.addJet();
				break;
			case "8":
				airField.deleteJet();
				break;
			case "9":
				run = false;
				System.out.println("Goodbye.");
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
}