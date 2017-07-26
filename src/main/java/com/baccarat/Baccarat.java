package com.baccarat;

import java.util.ArrayList;
import java.util.List;


public class Baccarat {
	private List<Result> results;
	private int n;
	
	public Baccarat(int numberOfGames, int numberOfDeck){
		n = numberOfGames;
		results = new ArrayList<>();
		for(int i=0; i<numberOfGames; i++){
			results.add(initialize(new Coups(numberOfDeck)));
		}
	}
	
	private Result initialize(Coups coups){
		return coups.play();
	}
	
	public void showPercentages(){
		int player = 0, banker = 0, tie = 0;
		for(Result result:results){
			switch(result){
				case PLAYERWIN: player++;
					break;
				case BANKERWIN: banker++;
					break;
				default: tie++;
					break;
			}
		}
		System.out.println(String.format("player win: %.2f%%", player*100.0/n));
		System.out.println(String.format("banker win: %.2f%%", banker*100.0/n));
		System.out.println(String.format("tie: %.2f%%", tie*100.0/n));
	}
	
	public static void main(String[] args){
		Baccarat baccarat = new Baccarat(8000, 8);
		baccarat.showPercentages();
	}
}
