package unitLoops;

import java.util.Scanner;

public class CoinGame {
	
	private int startingCoins;
	private int maxRounds;
	
	public CoinGame(int s, int m) {
		
		startingCoins = s;
		maxRounds = m;
		
	}
	
	public int getPlayer1Move() {
		
		int x = 1;
		int move = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of coins you would like to spend: ");
		
		start:
		while(x == 1) {
			switch(sc.nextLine()) {
			case "1":
				move = 1;
			case "2":
				move = 2;
			case "3":
				move = 3;
			default:
				System.out.println("Enter a different number - it must be 1 to 3.");
				continue start;
			}
		}
		
		return move;
	}
	
	public int getPlayer2Move(int round) {
		if(round%3 == 0) return 3;
		else if(round%3 != 0 && round%2==0) return 2;
		else return 1;
	}
	
	public void playGame() {
		int p1 = startingCoins;
		int p2 = startingCoins;
		int move1 = 0;
		int move2 = 0;
		
		for(int i = 1; i < maxRounds; i++) {
			System.out.println("Start Round " + i);
			
			move1 = getPlayer1Move();
			move2 = getPlayer2Move(i);
			
			p1 -= move1;
			p2 -= move2;
			
			if(p1 < 3 || p2 < 3) {
				i = maxRounds;
			}
			
			switch(Math.abs(move1 - move2)) {
			case 0:
				System.out.println("Players spent the same amount.\nPlayer 2 gets one coin because of the \"Same Rule\"");
				p2++;
				break;
			case 1:
				System.out.println("One player spent only one more than the other.\nPlayer 2 gets one coin because of the \"Off-By-One Rule\"");
				p2++;
				break;
			case 2:
				System.out.println("One player spent two more than the other.\nPlayer 1 gets two coins because of the \"Off-By-Two Rule\"");
				p1 += 2;
				break;
			}
			
			System.out.println("End Round " + i);
		}
		
		if(p1 > p2) System.out.println("P1 Wins!");
		else if(p1 < p2) System.out.println("P2 Wins!");
		else System.out.println("Tie Game!");
	}
	
}
