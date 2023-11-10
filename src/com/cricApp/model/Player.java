package com.cricApp.model;

import java.util.Objects;

public class Player implements Comparable<Player> {
	private String firstName ;
	private String lastName ;  
	private boolean isWicketKeeper ; 
	private double economy  ; 
	private double strikerate  ;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getName() {
		return firstName + " " + lastName ; 
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isWicketKeeper() {
		return isWicketKeeper;
	}
	public Player setWicketKeeper(boolean isWicketKeeper) {
		this.isWicketKeeper = isWicketKeeper;
		return this;  
	}
	public double getEconomy() {
		return economy;
	}
	public void setEconomy(double economy) {
		this.economy = economy;
	}
	public double getStrikerate() {
		return strikerate;
	}
	public void setStrikerate(double strikerate) {
		this.strikerate = strikerate;
	}
	
	public Player(String firstName, String lastName , double strikerate , double economy) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.economy = economy;
		this.strikerate = strikerate;
	}  
	
	public Player() {
		
	}
	@Override
	public String toString() {
		if ( isWicketKeeper) {
			return "[Name: " + firstName + " " + lastName + " : WK ]";
		}
		else 
			return "[Name: " + firstName + " " + lastName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(economy, firstName, isWicketKeeper, lastName, strikerate);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Double.doubleToLongBits(economy) == Double.doubleToLongBits(other.economy)
				&& Objects.equals(firstName, other.firstName) && isWicketKeeper == other.isWicketKeeper
				&& Objects.equals(lastName, other.lastName)
				&& Double.doubleToLongBits(strikerate) == Double.doubleToLongBits(other.strikerate);
	}
	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		String curName  = this.firstName + this.lastName ; 
		String passedName = o.firstName + o.lastName ; 
		return curName.compareTo(passedName);
	}
}