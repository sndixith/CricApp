package com.cricApp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cricApp.model.comporators.PlayerEconomyComparator;
import com.cricApp.model.comporators.PlayerStrikeRateComparator;
import com.cricApp.model.exceptions.PlayerDoesNotExistException;

public class Team {
	
	private String name;
	private int size;
	private List<Player> players = new ArrayList<>();

	public Team(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	public Team() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Player> getPlayers() {
		return players;
	}

	// ====================== Start of C ========================

	public void addPlayers(List<Player> players) {
		this.players.addAll(players);
	}

	// to add 1 player
	public void addPlayer(Player player) {
		this.players.add(player);
	}

	// ====================== End of C ===========================
	// ====================== Start of R =========================

	// get player by name
	public Player getPlayerByName(String name) {
		for (Player p : players) {
			if (p.getName().equalsIgnoreCase(name))
				return p;
		}
		throw new PlayerDoesNotExistException() ; 
	}// end of getPlayerByName

	// to get all batsmen
	public List<Batsman> getBatsmen() {

		ArrayList<Batsman> batsmen = new ArrayList<>();
		for (Player p : players) {
			if (p instanceof Batsman)
				batsmen.add((Batsman) p);
		}
		return batsmen;
	}// end of getBatsmen

	// to get all bowlers
	public List<Bowler> getBowlers() {

		ArrayList<Bowler> bowlers = new ArrayList<>();
		for (Player p : players) {
			if (p instanceof Bowler)
				bowlers.add((Bowler) p);
		}
		return bowlers;
	}// end of getBowlers

	// to check wicketkeeper is available or not
	public boolean hasWicketKeeper() {
		for (Player p : players) {
			if (p.isWicketKeeper()) {
				return true;
			}
		}
		return false;
	}

	// to get a wicket keeper
	public Player getWicketKeeper() {
		for (Player p : players) {
			if (p.isWicketKeeper()) {
				return p;
			}
		}
		return null;
	}

	// to return top 3 economic bowler
	public Bowler[] getTopThreeEconomicalBowler() {
		Bowler[] bowlers = new Bowler[3];
		List<Bowler> bow = getBowlers();
		Collections.sort(bow, new PlayerEconomyComparator());
		for (int i = 0; i < bowlers.length && i < bow.size(); i++) {
			bowlers[i] = bow.get(i);
		}
		return bowlers;
	}

	// to return top three batsmen based on Strikerate
	public Batsman[] getTopThreeEfficientBatsmen() {
		Batsman[] batsmen = new Batsman[3];
		List<Batsman> bat = getBatsmen();
		Collections.sort(bat, new PlayerStrikeRateComparator());
		Collections.reverse(bat);
		for (int i = 0; i < batsmen.length && i < bat.size()  ; i++) {
			batsmen[i] = bat.get(i);
		}
		return batsmen;
	}

	public int getPlayerPos(Player oldPlayer) {
		
		return  players.indexOf(oldPlayer);
	}

	// ======================= End Of R ======================================

	// ======================= Start of U ====================================
	// to replace a bowler
	public boolean replaceBowler(Bowler oldBowler, Bowler newBowler) {
		int i = players.indexOf(oldBowler);
		if (i >= 0) {
			players.set(i, newBowler);
			return true;
		}
		return false;
	}

	// to replace a batsman
	public boolean replaceBatsman(Batsman oldBatsman, Batsman newBatsman) {
		int i = players.indexOf(oldBatsman);
		if (i >= 0) {
			players.set(i, newBatsman);
			return true;
		}
		return false;
	}
	
	// to replace wicketKeeper 
	public boolean replaceWicketKeeper(Player oldKeeper , Player newKeeper) {
		int i = players.indexOf(oldKeeper) ; 
		newKeeper.setWicketKeeper(true);
		if ( i >= 0 ) {
			players.set(i, newKeeper) ; 
			return true  ; 
		}
		return false  ; 
	}
	//============================ end of U ==========================
	//============================ start of D ========================
	// to remove a player 
	public boolean removePlayer(Player p ) {
		return players.remove(p) ; 
	}

} // end of class