package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AirField {
	//F I E L D S
	private List<Jet> jetList = new ArrayList<>();
	
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
	
	
//	public void parkJet(Jet j) {
////		System.out.println(j);
//		this.jetList.add(j);
//	}
	
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
				int price = Integer.parseInt(newJet[3]);
				
				if (newJet[0].contentEquals("Fighter")) {
					jetList.add(new Jets(model, speed, range, price));
				} else if (newJet[0].contentEquals("Cargo")) {
					jetList.add(new CargoPlane(model, speed, range, price));
				}
				
				
				//				jetList.add(newJet);
				
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return jetList;
	}
}
	
//	public Jet listJetFleet() {
//		Jet j = new Jets();
//		for (int i = 0; i < jetList.size(); i++) {                         //// Change 5 to jet.length/size
//			String model = jetList.get(i)[1];
//			double speed = Double.parseDouble(jetList.get(i)[2]);
//			int range = Integer.parseInt(jetList.get(i)[3]);
//			int price = Integer.parseInt(jetList.get(i)[3]);
//			if (jetList.get(i)[0].equalsIgnoreCase("Fighter")) {
//				j = new Jets(model, speed, range, price);
//
//				return j;
//			} 
//		}
//		return j;
//	}
//	
//	public Jet listCargoFleet() {
//		Jet c = new CargoPlane();
//		for (int i = 0; i < jetList.size(); i++) {                         //// Change 5 to jet.length/size
//			String model = jetList.get(i)[1];
//			double speed = Double.parseDouble(jetList.get(i)[2]);
//			int range = Integer.parseInt(jetList.get(i)[3]);
//			int price = Integer.parseInt(jetList.get(i)[3]);
//			if (jetList.get(i)[0].equalsIgnoreCase("Cargo")) {
//				c = new CargoPlane(model, speed, range, price);
//				System.out.println(c.toString());	
//				return c;
//			}
//		}
//		return c;
//	}
//	
//	public void fastestJet() {
//		double fastest = 0;
//		String fastestJet = "";
//		for (int i = 0; i < jetList.size(); i++) {
//			if (jetList.get(i)[0].equalsIgnoreCase("Fighter")) {
//				if (fastest < Double.parseDouble(jetList.get(i)[2])) {
//					fastest = Double.parseDouble(jetList.get(i)[2]);
//					fastestJet = jetList.get(i)[1];	
//				}
//			}
//		}
//		System.out.println(fastestJet);
//	}
//
//	public void fastestJet2(Jet j) {
//		double fastest = 0;
//		String fastestJet = "";
//		for (int i = 0; i < jetList.size(); i++) {
//			if (fastest < j.getSpeed()) {
//				fastest = j.getSpeed();
//				fastestJet = j.getModel();
//			}
//		}
//		System.out.println(fastestJet);
//	} 
//}
