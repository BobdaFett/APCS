package BankAccount;

import java.util.ArrayList;

public class ObjectTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int max = -666;
		int min = -333;
		
		int newMax = (max % 2 == 0) ? max -= 1 : max;
		int newMin = (min % 2 == 0) ? min += 1 : min;
		int length = (newMax - newMin) / 2;
		
		int[] store = new int[length + 1];
		int count = 0;
		for(int i = min; i <= max; i += 2) {
			store[count] = i;
			count++;
		}
		
		for(int thing : store) {
			System.out.print(thing + " ");
		}
		
	}

}
