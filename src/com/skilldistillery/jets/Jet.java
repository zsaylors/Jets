package com.skilldistillery.jets;

public abstract class Jet {
	//F I E L D S
	private String model;
	private double speed;
	private int range;
	private int price;
	
	//C O N S T R U C T O R S
	public Jet() {
		
	}
	
	public Jet(String model, double speed, int range, int price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	//M E T H O D S
	public String fly() {
		return price + " " + model;
	}
	
	public double getSpeedInKnotsandMach() {
		return price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
