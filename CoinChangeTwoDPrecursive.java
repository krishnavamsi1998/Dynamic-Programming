package dp;

import java.util.Arrays;

//Return the number of combinations that make up that amount
//O(n*t),O(n*t)+O(stack)
public class CoinChangeTwoDPrecursive {
	
	private static int countWaysToMakeChange(int[] arr, int ind, int t, int[][] dp) {

			if(ind==0)
			{
				if(t%arr[0]==0)
					return 1;
				else
					return 0;
			}
			
			if(dp[ind][t]!=-1)
				return dp[ind][t];
			
			int notTake=countWaysToMakeChange(arr,ind-1,t,dp);
			int take=0;
			if(arr[ind]<=t)
				take=countWaysToMakeChange(arr,ind,t-arr[ind],dp);
		
		return dp[ind][t]=take+notTake;
	}


	public static void main(String[] args) {
		
		int[] arr= {2};
		int t=3;
		
		int n=arr.length;
		int[][] dp=new int[n][t+1];
		
		for(int[] row:dp)
			Arrays.fill(row, -1);
		
		System.out.println(countWaysToMakeChange(arr,n-1,t,dp));
		
		
	}

	
}
