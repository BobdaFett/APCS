package unitLoops;

import java.util.Scanner;

public class WhileTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int r = (int)(Math.random()*100)+1;
		
		int guess;
		int numGuess = 0;
		
		System.out.print("A random number has been generated.\nEnter a guess for the number's value: ");
		guess = s.nextInt();
		
		while(guess != r) {
			if(guess > r) {
				System.out.print("\n\nThat number was too high, try another number: ");
				guess = s.nextInt();
				numGuess++;
			} else {
				System.out.print("\n\nThat number was too low, try another number: ");
				guess = s.nextInt();
				numGuess++;
			}
		}
		
		System.out.println("You figured out the number! It took you " + numGuess + " tries to figure it out.");
		s.close();
	}

}