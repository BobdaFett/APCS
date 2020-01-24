package unitArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WhyArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] temp = new int[1];
		int getTemp = 0;
		int i = 0;
		Scanner input = new Scanner(System.in);

		while (getTemp != -200) {
			System.out.println("Enter a temperature.  Enter -200 when done: ");
			getTemp = input.nextInt();
			input.nextLine();
			if (i < temp.length) {
				temp[i] = getTemp;
				i++;
			} else {
				int count = 0;
				int[] expanded = new int[2 * temp.length];
				for (int j : temp) {
					expanded[count++] = j;
				}
				expanded[i++] = getTemp;
				temp = expanded;
			}
		}
		System.out.println(Arrays.toString(temp));

	}

}
