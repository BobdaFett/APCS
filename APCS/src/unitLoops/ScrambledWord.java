package unitLoops;

import java.util.Scanner;

public class ScrambledWord {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a word: ");
		String temp = sc.nextLine();
		sc.close();
		
		System.out.println("\nYour scrambled word is " + scrambleWord(temp));
		
	}
	
	public static String scrambleWord(String word) {
		
		String tempWord = word.toUpperCase();
		String tempResult = "";
		
		for(int i = 0; i < word.length(); i++) {
			char temp = word.charAt(i);
			char temp1 = word.charAt(i+1);
			
			if(temp == 'A' && temp1 != temp) {
				
				tempResult += tempWord.substring(i, i+1) + tempWord.substring(i+1, i+2);
				i+=2;
			}
		}
		
		return tempResult;
	}

}
