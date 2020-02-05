package unitLoops;

import java.util.Arrays;
import java.util.Scanner;

public class AverageTemperature {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = 0;

		System.out.print("Enter the number of temperatures you would like to enter: ");
		int[] temps = new int[sc.nextInt()];

		for (int i : temps) {
			System.out.print("\nEnter a temperature: ");
			temps[count++] = sc.nextInt();
		}

		double average = getAverage(temps);

		System.out.println("The average temperature was " + getAverage(temps));

		System.out.println(
				"\nThe temperatures that were above the average were " + Arrays.toString(getHighTemps(temps, average)));

	}

	/**
	 * Gets the average temperature from the passed list.
	 * 
	 * @param list
	 * @return
	 */
	public static double getAverage(int[] list) {
		double average = 0, sum = 0;

		for (int i : list) {
			sum += i;
		}

		average = sum / list.length;

		return average;
	}

	/**
	 * Gets temperatures above the passed average temperature.
	 * 
	 * @param list
	 * @param average
	 * @return
	 */
	public static int[] getHighTemps(int[] list, double average) {

		int count = 0;

		for (int i : list) {
			if (i > average) {
				count++;
			}
		}

		int[] result = new int[count];
		count = 0;

		for (int i : list) {
			if (i > average) {
				result[count++] = i;
			}
		}

		return result;

	}

}
