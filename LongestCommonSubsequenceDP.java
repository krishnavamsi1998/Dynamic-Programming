package dp;

//O(mn), O(mn)

public class LongestCommonSubsequenceDP {

	private static int lcs(String s1, String s2, int m, int n) {

		int[][] lcs = new int[m + 1][n + 1];

		// filling first row and first column 0 ,
		// because either of string is empty then subsequence is 0

		for (int i = 0; i <= m; i++)
			lcs[i][0] = 0;

		for (int j = 0; j <= n; j++)
			lcs[0][j] = 0;

		// logic
		// if equal take diagonal , else take max of left and top
		// since you have already filled for 0 row , 0 column
		// start from 1

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				else
					lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);

			}
		}

		// return last cell value i.e result
		return lcs[m][n];
	}

	private static int max(int a, int b) {

		return a > b ? a : b;
	}

	public static void main(String[] args) {

		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		int m = s1.length();
		int n = s2.length();

		System.out.println(lcs(s1, s2, m, n));

	}

	// op : 4

}
