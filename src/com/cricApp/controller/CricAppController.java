package com.cricApp.controller;

import java.util.Scanner;

import com.cricApp.model.Batsman;
import com.cricApp.model.Bowler;
import com.cricApp.model.Player;
import com.cricApp.model.Team;
import com.cricApp.model.exceptions.LowTeamSizeException;
import com.cricApp.model.exceptions.PlayerDoesNotExistException;

public class CricAppController{
	
	static Scanner s = new Scanner(System.in ) ; 
	private boolean sizeValidation(int size) {
		if (size >= 2)
			return true;
		throw new LowTeamSizeException();
	}

	private Batsman createBatsman(int i ) {
		System.out.println("=========== Player "+ i +" Details");
		System.out.println("Enter First Name : ");
		String firstName = s.next() ; 
		System.out.println("Enter Last Name : ");
		String lastName = s.next()  ; 
		System.out.println("Enter Strike Rate : ");
		double strikerate = s.nextDouble(); 
		System.out.println("Enter Economy: ") ; 
		double economy = s.nextDouble(); 
		return new Batsman(firstName, lastName, strikerate, economy );
	}
	

	private Bowler createBowler(int i ) {
		System.out.println("================ Player "+ i +" Details");
		System.out.println("Enter First Name : ");
		String firstName = s.next() ; 
		System.out.println("Enter Last Name : ");
		String lastName = s.next()  ; 
		System.out.println("Enter Strike Rate : ");
		double strikerate = s.nextDouble(); 
		System.out.println("Enter Economy: ") ; 
		double economy = s.nextDouble(); 
		return new Bowler(firstName, lastName, strikerate, economy );
	}

	private Player createPlayer(int i ) {
		Player player = null ; 
		System.out.println("Press 1 : Bowler");
		System.out.println("Press 2 : Batsmen");
		System.out.println("Press a number : ");
		int choice = s.nextInt() ;
		if ( choice  == 1 )
			return player =  createBowler( i );
		else if ( choice == 2 )
			 return player = createBatsman(i );
		else 
		{
			System.out.println("Invalid Selection ");
			return player = createPlayer(i ) ;
		}
	}
	
	private void assignKeeper(Team team) {
		System.out.println("========= Select Player For Assigning as Keeper ======");
		for( Player p  : team.getPlayers()) {
			System.out.println( p );
		}
		try {
			System.out.println("Enter Name for Assigning");
			System.out.println("Enter First Name: ");
			String firstName = s.next() ; 
			System.out.println("Enter Last Name: ");
			String lastName = s.next() ; 
			Player p = team.getPlayerByName(firstName+" "+lastName) ; 
			p.setWicketKeeper(true);
		}
		catch( PlayerDoesNotExistException e) {
			System.out.println(e.getMessage());
			assignKeeper(team);
		}
	}
	
	public Team createTeam() {
		Team team = new Team();
		System.out.println("========================= Create Team Menu ============================");
		System.out.println("Enter Team Name(Single Word): ");
		team.setName(s.next());
		System.out.println("Enter Team Size: ");
		final int size = s.nextInt() ; 
		team.setSize(size);
		if (sizeValidation(size)) {
			int halfsize = size / 2;
			System.out.println("============== Adding " + halfsize +" Batsmen ==============");
			for (int i = 0; i < halfsize; i++) {
				team.addPlayer(createBatsman(team.getPlayers().size() +1 ));
			}
			System.out.println("============== Adding " + halfsize +" Bowler ==============");
			for (int i = 0; i < halfsize; i++) {
				
				team.addPlayer(createBowler(team.getPlayers().size()+ 1));
			}
			if ( size % 2 == 1 ) {
				System.out.println("========== Chose any for the extra player ==============");
				team.addPlayer(createPlayer(team.getPlayers().size() + 1 ));
			}
			System.out.println("================== Team Generated ===========================");
			// assign keeper 
			assignKeeper( team ) ; 
			System.out.println("================== Team  "+ team.getName() + " created successfully=================");
		}
		return team;
	}
	
	public void displayTeam(Team team ) {
		System.out.println("================= Display Menu =======================");
		System.out.println("1. Display Team Members ");
		System.out.println("2. Display Batsmen");
		System.out.println("3. Display Bowlers");
		System.out.println("4. Display top 3 Batsmen ");
		System.out.println("5. Display top 3 Bowler " );
		System.out.println("6. Display WicketKeeper ");
		System.out.println("7. To Go Back To CricApp Main Menu");
		System.out.println("Enter Your Choice : ");
		int choice  = s.nextInt() ; 
		switch ( choice ) {
			case 1 : {
				// display team members 
				System.out.println("========== Team " + team.getName() + " Members ============");
				for( Player p : team.getPlayers()) {
					System.out.println( p );
				}
				System.out.println("+++++++++++++++++++++++++++++++++++");
			}
			break ; 
			case 2 : {
				// display Batsmen
				System.out.println("========== Team "+ team.getName() + " Batsmen ============");
				for( Player p : team.getBatsmen()) {
					System.out.println( p );
				}
				System.out.println("+++++++++++++++++++++++++++++++++++");
			}
			break ; 
			case 3 : {
				// display Bowler
				System.out.println("========== Team "+ team.getName() + " Bowler ============");
				for( Player p : team.getBowlers()) {
					System.out.println( p );
				}
				System.out.println("+++++++++++++++++++++++++++++++++++");
			}
			break ; 
			case 4 : {
				System.out.println("========== Team "+ team.getName() + " Top 3 Batsmen ============");
				for( Player p : team.getTopThreeEfficientBatsmen()) {
					if ( p != null) {
						((Batsman)p).diplayBatsmen() ;
					}
				}
				System.out.println("+++++++++++++++++++++++++++++++++++");
			}
			break ; 
			case 5 : {
				System.out.println("========== Team "+ team.getName() + " Top 3 Bowler ============");
				for( Player p : team.getTopThreeEconomicalBowler()) {
					if ( p != null) {
						((Bowler)p).diplayBowler() ;
					}
				}
				System.out.println("+++++++++++++++++++++++++++++++++++");
			}
			break ; 
			case 6 : {
				System.out.println("==========Team "+ team.getName() +" Wicket Keeper ============");
				Player p = team.getWicketKeeper() ;
				System.out.println( p );
				System.out.println("+++++++++++++++++++++++++++++++++++");
			}
			break ; 
			case 7 : {
				return  ; 
			}		
		}// end of switch 
		displayTeam(team )  ; 
	}

	private String readName() {
		System.out.println("Enter Name of The Player to be Updated: ");
		System.out.println("Enter First Name: ");
		String name = s.next().trim() ; 
		System.out.println("Enter Last Name: ");
		name += " "+ s.next().trim() ; 
		return name;
	}
	
	
	public void updateTeam(Team team) {
		System.out.println("================= Update Menu =======================");
		System.out.println("1. Replace Batsman ");
		System.out.println("2. Replace Bowler ");
		System.out.println("3. Replace Keeper ");
		System.out.println("4. Edit Player Name");
		System.out.println("5. To Go Back To CricApp Main Menu");
		System.out.println("Enter Your Choice : ");
		int choice  = s.nextInt() ; 
		switch ( choice ) {
			case 1 : {
				// Replace Batsman
				try {
					Player oldPlayer = team.getPlayerByName(readName()) ; 
					team.replaceBatsman((Batsman)oldPlayer , createBatsman(team.getPlayerPos(oldPlayer))) ; 
					if( oldPlayer.isWicketKeeper())
						assignKeeper(team);
					System.out.println("++++++++++++++++++++ Batsman Replaced +++++++++++++++");
				}
				catch(PlayerDoesNotExistException e ) {
					System.out.println(e.getMessage());
				}
			}
			break ; 
			case 2 : {
				// Replace Bowler
				try {
					Player oldPlayer = team.getPlayerByName(readName()) ; 
					team.replaceBowler((Bowler)oldPlayer , createBowler(team.getPlayerPos(oldPlayer))) ; 
					if( oldPlayer.isWicketKeeper())
						assignKeeper(team);
					System.out.println("++++++++++++++++++++ Bowler Replaced +++++++++++++++");
				}
				catch(PlayerDoesNotExistException e ) {
					System.out.println(e.getMessage());
				}
			}
			break ; 
			case 3 : {
				// replace Wicket Keeper 
				try {
					Player oldPlayer = team.getPlayerByName(readName()) ; 
					team.replaceWicketKeeper(oldPlayer, createPlayer(team.getPlayerPos(oldPlayer))) ; 
					System.out.println("++++++++++++++++++++ Keeper Replaced +++++++++++++++");
				}
				catch(PlayerDoesNotExistException e ) {
					System.out.println(e.getMessage());
				}
			}
			break ; 
			case 4 : {
				// Edit Name
				try {
					Player oldPlayer = team.getPlayerByName(readName()) ; 
					System.out.println("Enter First Name: ");
					oldPlayer.setFirstName(s.next());
					System.out.println("Enter Last Name: ");
					oldPlayer.setLastName(s.next());
					System.out.println("++++++++++++++++++++ Player Name Changed +++++++++++++++");
				}
				catch(PlayerDoesNotExistException e ) {
					System.out.println(e.getMessage());
				}
				
			}
			break ; 
			case 5 : {
				return  ; 
			}		
		}// end of switch 
		updateTeam(team);
	}
}