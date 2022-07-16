package dp;

//O(n),O(1)
//refer neetcode
public class HouseRobber1DPspaceOptimized {
	
	public static int rob(int[] nums) {
		
		int n=nums.length;
		if(n==1)
			return nums[0];
		if(n==2)
			return Math.max(nums[0], nums[1]);
		
		int rob1,rob2;
		rob1=rob2=0;
		
		
		for(int i:nums)
		{
			int res=Math.max(rob2, rob1+i);
			rob1=rob2;
			rob2=res;
		}
		
		return rob2;
		
		
	}
	
	public static void main(String[] args) {
		int[] arr = { 2, 7, 9, 3, 1 };
		System.out.println(rob(arr));
		
	}

}
