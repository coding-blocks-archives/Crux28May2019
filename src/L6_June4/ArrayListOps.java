package L6_June4;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Jun-2019
 *
 */

public class ArrayListOps {

	public static void main(String[] args) {

		// int[] one = { 10, 10, 20, 20, 30, 40, 40, 40 };
		// int[] two = { 10, 20, 20, 20, 30, 30, 40, 60, 70 };
		//
		// System.out.println(intersection(one, two));

		int[] one = { 8, 9, 9, 9, 8 };
		int[] two = { 2, 6 };

		System.out.println(sumArrays(one, two));
	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		int i = 0;
		int j = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				i++;
			} else if (one[i] > two[j]) {
				j++;
			} else {

				ans.add(one[i]);
				i++;
				j++;
			}

		}

		return ans;
	}

	public static ArrayList<Integer> sumArrays(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		int i = one.length - 1;
		int j = two.length - 1;

		int carry = 0;

		while (i >= 0 || j >= 0) {

			int sum = carry;

			if (i >= 0) {
				sum += one[i];
			}

			if (j >= 0) {
				sum += two[j];
			}

			int rem = sum % 10;
			ans.add(0, rem);
			carry = sum / 10;

			i--;
			j--;

		}

		if (carry != 0) {
			ans.add(0, carry);
		}

		return ans;
	}
}
