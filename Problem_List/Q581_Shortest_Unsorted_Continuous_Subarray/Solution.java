package Problem_List.Q581_Shortest_Unsorted_Continuous_Subarray;

class Solution {
	public int findUnsortedSubarray(int[] nums) {
		int n = nums.length;
		int left = 0, right = n - 1;
		
		// Крок 1: знайти перший порушений зліва
		while (left < n - 1 && nums[left] <= nums[left + 1]) {
			left++;
		}
		
		// Масив вже відсортований
		if (left == n - 1) return 0;
		
		// Крок 2: знайти перший порушений справа
		while (right > 0 && nums[right] >= nums[right - 1]) {
			right--;
		}
		
		// Крок 3: знайти min і max у проміжку
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = left; i <= right; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		
		// Крок 4: розширити межі, якщо потрібно
		while (left > 0 && nums[left - 1] > min) {
			left--;
		}
		while (right < n - 1 && nums[right + 1] < max) {
			right++;
		}
		
		return right - left + 1;
	}
}

