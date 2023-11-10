package com.cricApp.model;

public class Bowler extends Player {

	public void diplayBowler() {
		System.out.println("Name: " + getFirstName() + " " + getLastName() + ", Economy: " + getEconomy() );
	}
	
	public Bowler() {
		super();
		
	}

	public Bowler(String firstName, String lastName, double economy, double strikerate) {
		super(firstName, lastName, economy, strikerate);
		
	}

	@Override
	public String toString() {
		return "Bowler " + super.toString();
	}
}
