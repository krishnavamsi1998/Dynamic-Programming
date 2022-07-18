package dp;

//O(n*t),O(n*t)

public class MinimumCoinsDP {
	
	private static int minCoins(int[] arr, int t) {
		
		int n=arr.length;
		
		int[][] dp=new int[n][t+1];
		
		//base case
		//fill the 0th row
		for(int i=0;i<=t;i++)
		{
			if(i%arr[0]==0)
				dp[0][i]=i/arr[0];
			else
				dp[0][i]=(int)Math.pow(10,9);
			
		}
		
		for(int ind=1;ind<n;ind++)
		{
			for(int target=0;target<=t;target++)
			{
			
			int notTake=0+dp[ind-1][target];
			int take=(int)Math.pow(10,9);
			
			if(arr[ind]<=target)
				take=1+dp[ind][target-arr[ind]];
			
			dp[ind][target]=Math.min(notTake, take);
			
			}

		}
		
		int ans = dp[n-1][t];
	    if(ans >=(int)Math.pow(10,9)) 
	    	return -1;
	    return ans;
		
		
	
	}
	
	public static void main(String[] args) {
		
		int[] arr = { 9 ,6, 5, 1 };
		int n = arr.length;
		int sum = 11;
		int ans = minCoins(arr, sum);
		System.out.println(ans);
	}

	

}
