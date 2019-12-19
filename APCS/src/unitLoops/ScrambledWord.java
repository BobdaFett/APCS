package unitLoops;

import java.util.Scanner;

public class ScrambledWord {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a word: ");
		String temp = sc.nextLine();
		sc.close();
		
		scrambleWord(temp);
		
	}
	
	public static void scrambleWord(String word) {
		
		char[] tempWord = word.toUpperCase().toCharArray();
		
		for(int i = 0; i < tempWord.length - 1; i++) {
			if(tempWord[i] == 'A') {
				if(tempWord[i+1] != 'A') {
					char temp = 'A';
					tempWord[i] = tempWord[i+1];
					tempWord[i+1] = temp;
					i++;
				}
			}
		}
		
		System.out.print("\nYour scrambled word is ");
		for(char e : tempWord) {
			System.out.print(e);
		}
		
	}

}
