package Problem_List.Q665_Non_decreasing_Array;

class Solution {
	public boolean checkPossibility(int[] nums) {
		int count = 0; // кількість змін
		
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				count++;
				if (count > 1) return false;
				
				// Якщо nums[i-1] існує і nums[i-1] > nums[i+1], тоді змінюємо nums[i+1]
				if (i > 0 && nums[i - 1] > nums[i + 1]) {
					nums[i + 1] = nums[i];
				} else {
					// Інакше змінюємо nums[i]
					nums[i] = nums[i + 1];
				}
			}
		}
		
		return true;
	}
}
