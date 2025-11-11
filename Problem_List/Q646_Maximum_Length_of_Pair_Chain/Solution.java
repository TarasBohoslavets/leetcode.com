package Problem_List.Q646_Maximum_Length_of_Pair_Chain;

import java.util.Arrays;

class Solution {
	public int findLongestChain(int[][] pairs) {
		// Сортуємо пари за правим кінцем
		Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
		
		int count = 0;
		int currentEnd = Integer.MIN_VALUE;
		
		for (int[] pair : pairs) {
			if (pair[0] > currentEnd) {
				count++;
				currentEnd = pair[1];
			}
		}
		
		return count;
	}
}

