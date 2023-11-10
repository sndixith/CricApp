package com.cricApp.model.comporators;

import java.util.Comparator;

import com.cricApp.model.Player;

public class PlayerStrikeRateComparator implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		return (int)(Math.round(o1.getStrikerate()) - Math.round(o2.getStrikerate()));
	}
}