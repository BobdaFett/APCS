package unitLoops;

import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		String initial = "", flipped = "";
		
		System.out.print("Enter a string: ");
		initial = s.nextLine();
		String thisisdumb = initial;
		s.close();
		
		int i = 0;
		
		do {
			System.out.println(i);
			String temp = initial.substring(0, 1);
			flipped += temp;
			initial = initial.substring(1);
			i++;
		} while(i < thisisdumb.length());
		
		System.out.println("\n\n" + flipped);
	}

}
