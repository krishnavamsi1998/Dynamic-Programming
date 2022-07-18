package dp;

//the minimum coins that you will need to make up
//that sum if it’s not possible to construct that sum then return -1
//we have an infinite amount of coins of each type
public class MinimumCoinsRecursive {

	private static int minCoins(int[] arr, int target, int ind) {

		if (ind == 0) {
			if (target % arr[ind] == 0)
				return target / arr[ind];
			else
				return (int) Math.pow(10, 9);
		}
		//move to next index , i mean previous index 
		int notTake = 0 + minCoins(arr, target, ind - 1);

		// max value , to avoid over flow
		int take = (int) Math.pow(10, 9);
		if (arr[ind] <= target)
			//we stay at the same index
			take = 1 + minCoins(arr, target - arr[ind], ind);

		return Math.min(notTake, take);
	}

	public static void main(String[] args) {

		int[] arr = { 2, 4, 6, 8 };
		int n = arr.length;
		int target = 15;
		int ans = minCoins(arr, target, n - 1);
		if (ans >= (int) Math.pow(10, 9))
			System.out.println(-1);
		else
			System.out.println(ans);
	}

}
