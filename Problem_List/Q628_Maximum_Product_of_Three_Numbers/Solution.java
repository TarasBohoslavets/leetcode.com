package Problem_List.Q628_Maximum_Product_of_Three_Numbers;

import java.util.Arrays;

class Solution {
	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		
		int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
		int option2 = nums[0] * nums[1] * nums[n - 1];
		
		return Math.max(option1, option2);
	}
}