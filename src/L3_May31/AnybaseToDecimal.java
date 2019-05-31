package L3_May31;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 31-May-2019
 *
 */

public class AnybaseToDecimal {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in) ;
		int n = scn.nextInt() ;
		int sb = scn.nextInt() ;
		
		int ans = 0;
		int multiplier = 1; // 10 ^ 0

		while (n != 0) {

			int rem = n % 10;

			ans = ans + (rem * multiplier);

			multiplier = multiplier * sb;
			n = n / 10;

		}

		System.out.println(ans);
		
	}
}
