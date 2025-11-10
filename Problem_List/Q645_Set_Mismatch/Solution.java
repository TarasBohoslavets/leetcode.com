package Problem_List.Q645_Set_Mismatch;

class Solution {
	public int[] findErrorNums(int[] nums) {
		int[] count = new int[nums.length + 1];
		int duplicate = -1, missing = -1;
		
		for (int num : nums) {
			count[num]++;
		}
		
		for (int i = 1; i < count.length; i++) {
			if (count[i] == 2) duplicate = i;
			else if (count[i] == 0) missing = i;
		}
		
		return new int[]{duplicate, missing};
	}
}

