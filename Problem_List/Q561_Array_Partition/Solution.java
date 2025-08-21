package Problem_List.Q561_Array_Partition;

import java.util.Arrays;

class Solution {
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);  // Сортуємо масив
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2) {
			sum += nums[i];  // Беремо кожен другий елемент
		}
		return sum;
	}
}
