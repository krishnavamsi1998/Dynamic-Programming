package dp;

//O(n*t),O(n*t)
// the only difference between dp recursive and dp loop is 
// dp recursive needs extra stack space to store recursive calls
//but dp loop does not need that

public class CoinChangeTwoDPloop {
	
	private static int countWaysToMakeChange(int[] arr, int n, int t) {

		int[][] dp=new int[n][t+1];
		
		for(int i=0;i<=t;i++)
		{
			if(i%arr[0]==0)
				dp[0][i]=1;
			else
				dp[0][i]=0;
		}
		
		for(int ind=1;ind<n;ind++)
		{
			for(int target=0;target<=t;target++)
			{
				int notTake=dp[ind-1][target];
				int take=0;
				if(arr[ind]<=target)
					take=dp[ind][target-arr[ind]];
				
				dp[ind][target]=take+notTake;
			}
		}
			
		
		
		return dp[n-1][t];
	}


	public static void main(String[] args) {
		
		
		int[] arr= {2};
		int t=3;
		
		int n=arr.length;
		
		System.out.println(countWaysToMakeChange(arr,n,t));
		
		
	}

	
}
