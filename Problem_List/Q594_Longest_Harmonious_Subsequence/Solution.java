package Problem_List.Q594_Longest_Harmonious_Subsequence;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int findLHS(int[] nums) {
		Map<Integer, Integer> freq = new HashMap<>();
		int maxLen = 0;
		
		// Підрахунок частот
		for (int num : nums) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}
		
		// Пошук пар з різницею 1
		for (int key : freq.keySet()) {
			if (freq.containsKey(key + 1)) {
				int len = freq.get(key) + freq.get(key + 1);
				maxLen = Math.max(maxLen, len);
			}
		}
		
		return maxLen;
	}
}
