package L3_May31;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 31-May-2019
 *
 */

public class DecimalToAnybase {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int db = scn.nextInt();
	
		int ans = 0;
		int multiplier = 1; // 10 ^ 0

		while (n != 0) {

			int rem = n % db;

			ans = ans + (rem * multiplier);

			multiplier = multiplier * 10;
			n = n / db;

		}

		System.out.println(ans);

	}

}












