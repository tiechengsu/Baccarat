package com.baccarat;

public class Coups {
	private Card[] playerCard;
	private Card[] bankerCard;
	private int playerPoints;
	private int bankerPoints;
	private Shoe shoe;
	private int idx;
	
	public Coups(int numOfDecks){
		playerCard = new Card[3];
		bankerCard = new Card[3];
		playerPoints = 0;
		bankerPoints = 0;
		shoe = new Shoe(numOfDecks);
		idx = 0;
	}
	
	public Result play(){
		if(shoe.getSize()<4){
			return null;
		}
		for(int i=0; i<2; i++){
			playerCard[idx] = shoe.getCard();
			playerPoints+=playerCard[idx].getPoint();
			bankerAddPoints(idx);
			idx++;
		}
		playerPoints%=10;
		bankerPoints%=10;
		if(playerPoints>=8||bankerPoints>=8){
			return checkResult();
		}
		return hardCase();
	}
	
	private Result checkResult(){
		if(playerPoints>bankerPoints){
			return Result.PLAYERWIN;
		}else if(playerPoints<bankerPoints){
			return Result.BANKERWIN;
		}else{
			return Result.TIE;
		}
	}
	
	private Result hardCase(){
		if(playerPoints<=5){
			playerCard[idx] = shoe.getCard();
			int third = playerCard[idx].getPoint();
			playerPoints += third;
			switch(bankerPoints){
				case 0: case 1: case 2:
					bankerAddPoints(idx);
				case 3:
					if(third!=8){
						bankerAddPoints(idx);
					}
					break;
				case 4:
					if(third>=2&&third<=7){
						bankerAddPoints(idx);
					}
					break;
				case 5:
					if(third>=4&&third<=7){
						bankerAddPoints(idx);
					}
					break;
				case 6:
					if(third==6||third==7){
						bankerAddPoints(idx);
					}
					break;
				default:
					break;
			}
		}else{
			if(bankerPoints<=5){
				bankerAddPoints(idx);
			}
		}
		playerPoints %= 10;
		bankerPoints %= 10;
		return checkResult();
	}
		
	private void bankerAddPoints(int idx){
		bankerCard[idx] = shoe.getCard();
		bankerPoints+=bankerCard[idx].getPoint();
	}
		
	
	
}
