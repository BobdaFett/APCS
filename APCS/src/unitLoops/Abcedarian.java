package unitLoops;

import java.util.Scanner;

public class Abcedarian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter a string: ");
		System.out.println(isAbcedarian(new Scanner(System.in).nextLine()));
	}
	
	public static boolean isAbcedarian(String str) {
		for(int i = 1; i < str.length(); i++) {
//			System.out.println(str.substring(i, i+1).compareTo(str.substring(i-1, i)));
			if(str.substring(i, i+1).compareTo(str.substring(i-1, i)) < 1) {
				return false;
			}
		}
		return true;
	}

}
