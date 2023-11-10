package com.cricApp.launcher;

import com.cricApp.models.Game;
import com.cricApp.view.CricApp;

public class GameAppLauncher {

	static {
		for( int i = 0 ; i < 3 ; i++ ) {
			System.out.println("App is Loading.......");
			try {
				Thread.sleep(2000);
			}
			catch( InterruptedException e ) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		Game  app = new CricApp() ;
		System.out.println(app.getClass().getName() + " Launched..!!");
		/*
		 *  integrate CricApp 
		 *  Step 1 : create instance of Cric App 
		 *  Step 2 : call runApp method  
		 */
		app.runAppView();
	}	
}