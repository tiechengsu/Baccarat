package com.baccarat;

public class Card {
	private CardValue value;
	private Suit suit;
	private int point;
	
	public Card(Suit suit, CardValue value){
		this.value = value;
		this.suit = suit;
		int idx = value.ordinal()+1;
		this.point = idx>=10? 0:idx;
	}
	
	public int getPoint(){
		return point;
	}
}
