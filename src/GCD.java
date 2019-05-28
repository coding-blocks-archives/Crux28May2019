import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-May-2019
 *
 */

public class GCD {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n1 = scn.nextInt();
		int n2 = scn.nextInt();

		int n;

		if (n1 > n2) {
			n = n2;
		} else {
			n = n1;
		}

		int ans = 1;

		int div = n;
		while (div >= 1) {

			if (n1 % div == 0 && n2 % div == 0) {
				ans = div;
				break;
			}

			div = div - 1;

		}

		System.out.println(ans);

	}
}
