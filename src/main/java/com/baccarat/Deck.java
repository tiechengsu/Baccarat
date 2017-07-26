package com.baccarat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<Card> cards;
	
	public Deck(){
		cards = new ArrayList<>();
		for(Suit suit:Suit.values()){
			for(CardValue value:CardValue.values()){
				Card card = new Card(suit, value);
				cards.add(card);
			}
		}
	}
	
	//get a random card from Deck
	public Card getCard(){
		Random r = new Random();
		int idx = r.nextInt(cards.size());
		return cards.remove(idx);
	}
	
	//get the size of Deck
	public int getSize(){
		return cards.size();
	}
	
}
