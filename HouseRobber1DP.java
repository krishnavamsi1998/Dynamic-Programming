package dp;

public class HouseRobber1DP {

	public static int rob(int[] nums) {

		int n = nums.length;
		int[] dp = new int[n + 1];
		// max houses u can rob after 0 visited
		dp[0] = 0;
		// max houses u can rob after 1 visited
		dp[1] = nums[0];

		// since 0th index house already visited , we start from 1
		for (int i = 1; i < n; i++) {
      //logic
			dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
		}
		// dp[n] will be the max house u can rob after visiting n houses
		return dp[n];

	}

	public static void main(String[] args) {

		int[] arr = { 2, 7, 9, 3, 1 };
		System.out.println(rob(arr));
	}

}
