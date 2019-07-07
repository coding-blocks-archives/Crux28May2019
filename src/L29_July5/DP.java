package L29_July5;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Jul-2019
 *
 */

public class DP {

	public static void main(String[] args) {

		// int n = 200;

		long start = System.currentTimeMillis();

		// System.out.println(fibonacci(n));
		// int[][] strg = new int[n + 1][n + 1];
		// System.out.println(fibonacciTD(n, strg));
		// System.out.println(fibonacciBU(n));
		// System.out.println(fibonacciBUSE(n));
		// System.out.println(boardPathTD(0, n, strg));
		// System.out.println(boardPathBU(n));
		// System.out.println(boardpathBUSE(n));

		// System.out.println(mazePathTD(0, 0, n, n, strg));
		// System.out.println(mazePathBU(n, n));
		// System.out.println(mazePathBUSE(n, n));

		String s1 = "saturdayhbcjxdhvjdhkjvhdifvoei";
		String s2 = "sundaybchjcbdhjdbvhdfb";
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				strg[i][j] = -1;
			}
		}

		// System.out.println(LCSTD(s1, s2, strg)); // 11 // 8 sec
		// System.out.println(LCSBU(s1, s2));
		// System.out.println(EditDistanceTD(s1, s2, strg));
		// System.out.println(EditDistanceBU(s1, s2));

		int n = 100;
		int[] arr = new int[n];
		for (int i = 0; i <= arr.length - 1; i++) {
			arr[i] = i + 1;
		}

		// int[] arr = { 4, 5, 3, 21, 9, 70, 89, 12, 3, 4, 5, 6 };
		// System.out.println(MCM(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// System.out.println(MCMBU(arr));

		// int[] arr = { 2, 3, 5, 1, 4 };
		// System.out.println(WineProblem(arr, 0, arr.length - 1, 1));
		// System.out.println(WineProblemTD(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// System.out.println(WineProblemBU(arr));

		String src = "baaabajhdgvhcsdgvusegykvueguybbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
		String pat = "****************dhjgvu**********************************************************************************";

		// System.out.println(WildcardMatching(src, pat));
		System.out.println(WildcardMatchingTD(src, pat, new int[src.length() + 1][pat.length() + 1]));
		System.out.println(WildcardMatchingBU(src, pat));
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	// Time : 2^n , Space : n
	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	// Time : n , Space : n + n
	public static int fibonacciTD(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) { // re-use
			return strg[n];
		}

		int fnm1 = fibonacciTD(n - 1, strg);
		int fnm2 = fibonacciTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		strg[n] = fn; // store

		return fn;

	}

	// Time : n , Space : n
	public static int fibonacciBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];

	}

	// Time : n , Space : O(1)
	public static int fibonacciBUSE(int n) {

		int[] strg = new int[2];
		strg[0] = 0;
		strg[1] = 1;

		for (int slide = 1; slide <= n - 1; slide++) {

			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;

		}

		return strg[1];

	}

	public static int boardPath(int curr, int end) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int c = 0;
		for (int dice = 1; dice <= 6; dice++) {
			c += boardPath(curr + dice, end);
		}

		return c;

	}

	public static int boardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) { // re-use
			return strg[curr];
		}

		int c = 0;
		for (int dice = 1; dice <= 6; dice++) {
			c += boardPathTD(curr + dice, end, strg);
		}

		strg[curr] = c; // strg

		return c;

	}

	public static int boardPathBU(int n) {

		int[] strg = new int[n + 6];

		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];
	}

	public static int boardPathBUSE(int n) {

		int[] strg = new int[6];
		strg[0] = 1;

		for (int slide = 1; slide <= n; slide++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = sum;
		}

		return strg[0];

	}

	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = mazePathTD(cr, cc + 1, er, ec, strg);
		int cv = mazePathTD(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;

		return ch + cv;

	}

	public static int mazePathBU(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		for (int r = er; r >= 0; r--) {
			for (int c = ec; c >= 0; c--) {

				if (r == er && c == ec) {
					strg[r][c] = 1;
				} else {
					strg[r][c] = strg[r + 1][c] + strg[r][c + 1];
				}
			}
		}

		return strg[0][0];

	}

	public static int mazePathBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);

		for (int r = er - 1; r >= 0; r--) { // slide
			for (int c = ec - 1; c >= 0; c--) { // right to left col fill
				strg[c] = strg[c] + strg[c + 1];
			}
		}

		return strg[0];
	}

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans;
		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {

			int o1 = LCS(s1, ros2);
			int o2 = LCS(ros1, s2);

			ans = Math.max(o1, o2);
		}

		return ans;

	}

	public static int LCSTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (strg[s1.length()][s2.length()] != -1) {
			return strg[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans;
		if (ch1 == ch2) {
			ans = LCSTD(ros1, ros2, strg) + 1;
		} else {

			int o1 = LCSTD(s1, ros2, strg);
			int o2 = LCSTD(ros1, s2, strg);

			ans = Math.max(o1, o2);
		}

		strg[s1.length()][s2.length()] = ans; // strg

		return ans;

	}

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {

					int o1 = strg[row][col + 1];
					int o2 = strg[row + 1][col];

					strg[row][col] = Math.max(o1, o2);
				}

			}

		}

		return strg[0][0];

	}

	public static int EditDistanceTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		if (strg[s1.length()][s2.length()] != -1) {
			return strg[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = EditDistanceTD(ros1, ros2, strg);
		} else {

			int i = EditDistanceTD(ros1, s2, strg);
			int d = EditDistanceTD(s1, ros2, strg);
			int r = EditDistanceTD(ros1, ros2, strg);

			ans = Math.min(i, Math.min(d, r)) + 1;

		}

		strg[s1.length()][s2.length()] = ans;

		return ans;

	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col; // deletion
					continue;
				}

				if (col == s2.length()) {
					strg[row][col] = s1.length() - row; // insertion
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {

					int i = strg[row + 1][col];
					int d = strg[row][col + 1];
					int r = strg[row + 1][col + 1];

					strg[row][col] = Math.min(i, Math.min(d, r)) + 1;

				}

			}
		}

		return strg[0][0];

	}

	public static int MCM(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int lp = MCM(arr, si, k, strg);
			int rp = MCM(arr, k, ei, strg);

			int sw = arr[si] * arr[k] * arr[ei]; // fp : arr[si]* arr[k] sp : arr[k] * arr[ei]

			int total = lp + rp + sw;

			if (total < min) {
				min = total;
			}
		}

		strg[si][ei] = min;

		return min;
	}

	public static int MCMBU(int[] arr) {

		int n = arr.length;

		int[][] strg = new int[n][n];

		// work for diagonal
		for (int slide = 1; slide <= n - 2; slide++) {

			for (int si = 0; si <= n - slide - 2; si++) {

				int ei = si + slide + 1;

				// si, ei reach : use the logic from TD

				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int lp = strg[si][k];
					int rp = strg[k][ei];

					int sw = arr[si] * arr[k] * arr[ei]; // fp : arr[si]* arr[k] sp : arr[k] * arr[ei]

					int total = lp + rp + sw;

					if (total < min) {
						min = total;
					}
				}

				strg[si][ei] = min;

			}

		}

		return strg[0][n - 1];

	}

	public static int WineProblem(int[] arr, int si, int ei, int yr) {

		if (si == ei) {
			return arr[si] * yr;
		}

		int start = WineProblem(arr, si + 1, ei, yr + 1) + arr[si] * yr;
		int end = WineProblem(arr, si, ei - 1, yr + 1) + arr[ei] * yr;

		int ans = Math.max(start, end);

		return ans;

	}

	public static int WineProblemTD(int[] arr, int si, int ei, int[][] strg) {

		int yr = arr.length - ei + si;

		if (si == ei) {
			return arr[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int start = WineProblemTD(arr, si + 1, ei, strg) + arr[si] * yr;
		int end = WineProblemTD(arr, si, ei - 1, strg) + arr[ei] * yr;

		int ans = Math.max(start, end);

		strg[si][ei] = ans;

		return ans;

	}

	public static int WineProblemBU(int[] arr) {

		int n = arr.length;

		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				int yr = n - ei + si;

				if (si == ei) {
					strg[si][ei] = arr[si] * yr;
				} else {

					int start = strg[si + 1][ei] + arr[si] * yr;
					int end = strg[si][ei - 1] + arr[ei] * yr;

					int ans = Math.max(start, end);

					strg[si][ei] = ans;
				}
			}

		}

		return strg[0][n - 1];

	}

	public static boolean WildcardMatching(String src, String pat) {

		if (src.length() == 0 && pat.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pat.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pat.length() != 0) {

			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}

			return true;

		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);

		String ros = src.substring(1);
		String rop = pat.substring(1);

		boolean ans;
		if (chs == chp || chp == '?') {
			ans = WildcardMatching(ros, rop);
		} else if (chp == '*') {
			ans = WildcardMatching(src, rop) || WildcardMatching(ros, pat);
		} else {
			ans = false;
		}

		return ans;

	}

	public static int WildcardMatchingTD(String src, String pat, int[][] strg) {

		if (strg[src.length()][pat.length()] != 0) {
			return strg[src.length()][pat.length()];
		}

		if (src.length() == 0 && pat.length() == 0) {
			return 2;
		}

		if (src.length() != 0 && pat.length() == 0) {
			return 1;
		}

		if (src.length() == 0 && pat.length() != 0) {

			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return 1;
				}
			}

			return 2;

		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);

		String ros = src.substring(1);
		String rop = pat.substring(1);

		int ans;
		if (chs == chp || chp == '?') {
			ans = WildcardMatchingTD(ros, rop, strg);
		} else if (chp == '*') {

			if (WildcardMatchingTD(src, rop, strg) == 2 || WildcardMatchingTD(ros, pat, strg) == 2)
				ans = 2;
			else
				ans = 1;
		} else {
			ans = 1;
		}

		strg[src.length()][pat.length()] = ans;

		return ans;

	}

	public static boolean WildcardMatchingBU(String src, String pat) {

		boolean[][] strg = new boolean[src.length() + 1][pat.length() + 1];

		for (int r = src.length(); r >= 0; r--) {
			for (int c = pat.length(); c >= 0; c--) {

				if (r == src.length() && c == pat.length()) {
					strg[r][c] = true;
					continue;
				}
				if (c == pat.length()) {
					strg[r][c] = false;
					continue;
				}

				if (r == src.length()) {

					if (pat.charAt(c) == '*') {
						strg[r][c] = strg[r][c + 1];
					} else {
						strg[r][c] = false;
					}

					continue;
				}

				char chs = src.charAt(r);
				char chp = pat.charAt(c);

				boolean ans;
				if (chs == chp || chp == '?') {
					ans = strg[r + 1][c + 1];
				} else if (chp == '*') {
					ans = strg[r][c + 1] || strg[r + 1][c];
				} else {
					ans = false;
				}

				strg[r][c] = ans;
			}

		}

		return strg[0][0];

	}

}
