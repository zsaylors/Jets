//Additional Objectives if time permits later:
//1.  Look into if there are any stretch goals I want to implement.
//3.  Try switching for loops to for each loops for practice.

package com.skilldistillery.jets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {
	private Scanner kb = new Scanner(System.in);

	private AirField airField = new AirField(null);

	public static void main(String[] args) {
		JetsApplication j = new JetsApplication();
		j.launch();
	}

	private void launch() {
		displayMenu(kb);
	}

	private void displayMenu(Scanner kb) {
		boolean run = true;
		while (run) {
			printedMenu();
			String userChoice = kb.nextLine();

			switch (userChoice) {
			case "1":
				airField.listFleet();
				airField.noPlanes();
				break;
			case "2":
				airField.flyAll();
				airField.noPlanes();
				break;
			case "3":
				airField.flySingle();
				airField.noPlanes();
				break;
			case "4":
				airField.fastestJet();
				airField.noPlanes();
				break;
			case "5":
				airField.longestRange();
				airField.noPlanes();
				break;
			case "6":
				airField.addCargo();
				break;
			case "7":
				airField.dogFight();
				break;
			case "8":
				airField.train();
				break;
			case "9":
				airField.addJet();
				break;
			case "10":
				airField.deleteJet();
				airField.noPlanes();
				break;
			case "11":
				run = false;
				save();
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("That is an invalid entry.  Enter a value 1 - 9.");
				break;
			}

		}
	}

	private void printedMenu() {
		StringBuilder menu = new StringBuilder(
				"\n| \uD83D\uDE81 Fleet Fly In  \uD83D\uDEE9 |\n\n" 
		+ "1.  List fleet\n" 
		+ "2.  Fly all aircraft\n" 
		+ "3.  Fly single aircraft\n"
		+ "4.  View fastest aircraft\n"
		+ "5.  View aircraft with longest range\n" 
		+ "6.  Load all cargo aircraft\n" 
		+ "7.  Dogfight!\n"
	    + "8.  Train\n"
		+ "9.  Add aircraft to fleet\n"
		+ "10. Remove aircraft from fleet\n"
		+ "11. Quit");
		System.out.println(menu);
	}
	
	private void save() {
		System.out.println("Do you wish to save.  It will overwrite the previous file.\n(Y/N?):");
		String saveInput = kb.nextLine();
		if (saveInput.equalsIgnoreCase("Y")) {
			String outFileName = "myJetList.txt";
			writePlanes(outFileName, airField.getJetList());
			System.out.println("Saved!");
		} else {
			System.out.println("Not saved.");
		}
	}
	
	private void writePlanes(String outFileName, List<Jet> jetList) {
	    try {
	      PrintWriter pw = new PrintWriter(new FileWriter(outFileName));
	      for (Jet j : jetList) {
	        StringBuilder sb = new StringBuilder();
	        if (j instanceof CargoPlane) {
	        	sb.append("Cargo, ");
	        } else if (j instanceof FighterJet) {
	        	sb.append("Fighter, ");
	        } else if (j instanceof Trainer) {
	        	sb.append("Trainer, ");
	        } else {
	        	sb.append("Other, ");
	        }
	        sb.append(j.getModel());
	        sb.append(", ");
	        sb.append(j.getSpeed());
	        sb.append(", ");
	        sb.append(j.getRange());
	        sb.append(", ");
	        sb.append(j.getPrice());
	        pw.println(sb);
	      }
	      pw.close();
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
}