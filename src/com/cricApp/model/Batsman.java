package com.cricApp.model;

public class Batsman extends Player {

	public void diplayBatsmen() {
		System.out.println("Name: " + getFirstName() + " " + getLastName() + ", Strike Rate: " + getStrikerate() );
	}
	
	
	public Batsman() {
		super();
		
	}
	
	public Batsman(String firstName, String lastName, double economy, double strikerate) {
		super(firstName, lastName, economy, strikerate);
	}

	@Override
	public String toString() {
		return "Batsman " + super.toString() ;
	}
}