package com.baccarat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shoe {
	
	private int n;
	private List<Deck> decks;
	
	public Shoe(int numOfShoe){
		decks = new ArrayList<>();
		n = numOfShoe;
		for(int i=0; i<n; i++){
			decks.add(new Deck());
		}
	}
	
	//get a random card from shoe
	public Card getCard(){
		Random r = new Random();
		int idx = r.nextInt(n);
		if(decks.get(idx).getSize()==0){
			decks.remove(idx);
			n--;
			getCard();
		}
		return decks.get(idx).getCard();
	}
	
	public int getSize(){
		return n;
	}
}
