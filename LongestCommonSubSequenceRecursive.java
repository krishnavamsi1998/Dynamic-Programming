package dp;

// time -O(2^(m+n)) since for each and every character there are 2 possibilties 
// either its part of subsequence or not

// space -O(max(m,n)) size of recursion tree

public class LongestCommonSubSequenceRecursive {

	private static int lcs(char[] x, char[] y, int m, int n) {
		
		// if either of them are empty , then lcs is 0
		if (m ==0 || n==0)
			return 0;

		// if equal
		if (x[m - 1] == y[n - 1])

			return 1 + lcs(x, y, m - 1, n - 1);
		else
			// if not the max of top and left
			return max(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));

	}

	private static int max(int a, int b) {

		return a > b ? a : b;
	}

	public static void main(String[] args) {

		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		int m = s1.length();
		int n = s2.length();

		System.out.println(lcs(s1.toCharArray(), s2.toCharArray(), m, n));

	}

}
