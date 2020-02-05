package BankAccount;

import java.util.ArrayList;

public class ObjectTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int count = 0;
		int[] array = {984,948,984,98,4,4,0,4,4,4,89,0,55595,5,5999,5};
		int[] reverse = new int[array.length];
		
		for(int i : array) {
			System.out.println(i);
		}
		
		for (int i = array.length-1; i >= 0; i--) {
			reverse[i] = array[count];
			count++;
		}
		
		for(int i : reverse) {
			System.out.println(i);
		}
		
		array = reverse;
		
		
		
	}

}
