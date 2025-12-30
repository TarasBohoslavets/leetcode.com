package Problem_List.Q689_Maximum_Sum_of_3_Non_Overlapping_Subarrays;

class Solution {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int n = nums.length;
		int[] sum = new int[n - k + 1];
		int windowSum = 0;
		
		// обчислюємо суму кожного підмасиву довжини k
		for (int i = 0; i < n; i++) {
			windowSum += nums[i];
			if (i >= k) windowSum -= nums[i - k];
			if (i >= k - 1) sum[i - k + 1] = windowSum;
		}
		
		int[] left = new int[sum.length];
		int best = 0;
		for (int i = 0; i < sum.length; i++) {
			if (sum[i] > sum[best]) best = i;
			left[i] = best;
		}
		
		int[] right = new int[sum.length];
		best = sum.length - 1;
		for (int i = sum.length - 1; i >= 0; i--) {
			if (sum[i] >= sum[best]) best = i; // >= для лексикографічного порядку
			right[i] = best;
		}
		
		int[] ans = new int[3];
		int maxSum = 0;
		for (int j = k; j < sum.length - k; j++) {
			int i = left[j - k];
			int l = right[j + k];
			int total = sum[i] + sum[j] + sum[l];
			if (total > maxSum) {
				maxSum = total;
				ans[0] = i;
				ans[1] = j;
				ans[2] = l;
			}
		}
		
		return ans;
	}
}