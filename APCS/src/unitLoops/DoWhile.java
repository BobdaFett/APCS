package unitLoops;

import java.util.ArrayList;
import java.util.Collections;

public class DoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> something = new ArrayList<String>();
		something.add("string");
		something.add("Another String");

		System.out.println(search(something, "not a correct string"));

		//		Scanner s = new Scanner(System.in);
		//		String initial = "", flipped = "";
		//		
		//		System.out.print("Enter a string: ");
		//		initial = s.nextLine();
		//		String thisisdumb = initial;
		//		s.close();
		//		
		//		int i = 0;
		//		
		//		do {
		//			System.out.println(i);
		//			String temp = initial.substring(0, 1);
		//			flipped += temp;
		//			initial = initial.substring(1);
		//			i++;
		//		} while(i < thisisdumb.length());
		//		
		//		System.out.println("\n\n" + flipped);
		//	}

	}

	public static <T> boolean search(ArrayList<T> e, Object o) {
		return e.contains(o);
	}

	public static <T> void swap(ArrayList<T> e, int a, int b) {
		Collections.swap(e, a, b);
	}

	//	public static <T> T max(ArrayList<T> e) {
	//		T max = null;
	//		for (T i : e) {
	//			if (i > max) //idk how to fix this
	//				max = i;
	//		}
	//	}
}
