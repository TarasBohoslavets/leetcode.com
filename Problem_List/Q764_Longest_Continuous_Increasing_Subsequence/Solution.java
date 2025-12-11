package Problem_List.Q764_Longest_Continuous_Increasing_Subsequence;

class Solution {
	public int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0) return 0;
		
		int maxLen = 1;
		int curLen = 1;
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				curLen++;
			} else {
				curLen = 1;
			}
			maxLen = Math.max(maxLen, curLen);
		}
		
		return maxLen;
	}
}

