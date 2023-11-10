package com.cricApp.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.cricApp.controller.CricAppController;
import com.cricApp.model.Batsman;
import com.cricApp.model.Bowler;
import com.cricApp.model.Player;
import com.cricApp.model.Team;
import com.cricApp.models.Game;

public class CricApp implements Game{
	
	private CricAppController controller = new CricAppController()  ; 
	private Team team  ;
	
	// Uncomment for test scenario
//	{
//		team  = new Team() ; 
//		team.setName("India");
//		List<Player> player = new ArrayList<Player>(Arrays.asList(
//							new Batsman("sachin","Tendulkar"	,98.0 ,8) , 
//							new Bowler("Ashish", "Nehra", 35, 3.2), 
//							new Bowler("Mohamad", "Shami", 40, 4.3),
//							new Bowler("Mohammad", "Siraj", 70, 3.0) , 
//							new Bowler("Kuldeep", "singh", 35, 2.8),
//							new Batsman("Virendra","Shewag"	,130 ,8.6) ,
//							new Batsman("Rahul","Dravid"	, 70.8 , 7 ).setWicketKeeper(true),
//							new Batsman("Sourav","Ganguly"	, 95.0 ,8 ),
//							new Batsman("Yuvraj","Singh"	, 87.5, 5)
//							)) ; 
//		team.addPlayers(player);
//		team.setSize(team.getPlayers().size());
//	}
	
	//==========================================================================
	
	static Scanner s = new Scanner(System.in); 
	// main method for runing the app 
	public void runAppView() {
		System.out.println("===================== Welcome To CricApp Main Menu ===============") ;
		boolean repeat = true  ; 
		do {
			// front End view 
			System.out.println("Press 1. Create Team ");
			System.out.println("Press 2. Display Team Details");
			System.out.println("Press 3. Update Team");
			System.out.println("Press 4. Delete Team");
			System.out.println("Press 5. Exit CricApp") ; 
			System.out.println("Press Numeric Key : ");
			int choice  = s.nextInt() ; 
			switch(choice) {
				case 1 : {
					// create Team Menu
					if ( team == null )
						team  = controller.createTeam();
					else 
					{
						System.out.println("========== Team Already Exists ===========");
						System.out.println("Delete team to add new Team..!!");
					}
						
				}
				break  ;
				case 2 : {
					// Display Team Menu 
					if( team != null )
						controller.displayTeam(team);
					else 
						System.out.println("============ kindly Create A team first =================");
				}
				break  ; 
				case 3 : {
					// update Menu
					if( team != null ) {
						controller.updateTeam(team) ; 
					}
					else 
						System.out.println("============ kindly Create A team first =================");
					
				}
				break  ; 
				case 4 : {
					
					if( team != null  ) {
						team = null ; 
						System.out.println("============================== Team Deleted =================");
					}
					else {
						System.out.println("=========================== Team Does not exist ================== ");
					}
				}
				break  ; 
				case 5 : {
					System.out.println("Thank You  ");
					repeat = false  ; 
				}
				break ; 
				default : {
					System.out.println("Invalid Input !!");
					
				}
			} // end of Switch 
		}while( repeat ) ; 
		System.out.println("===================== *************** ===============") ;

	}
	

}
