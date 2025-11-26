package Problem_List.Q659_Split_Array_into_Consecutive_Subsequences;

import java.util.*;

class Solution {
	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> count = new HashMap<>();
		Map<Integer, Integer> end = new HashMap<>();
		
		// Підрахунок частот
		for (int num : nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}
		
		for (int num : nums) {
			if (count.get(num) == 0) continue;
			
			// Використовуємо num
			count.put(num, count.get(num) - 1);
			
			// Якщо можемо продовжити існуючу послідовність
			if (end.getOrDefault(num - 1, 0) > 0) {
				end.put(num - 1, end.get(num - 1) - 1);
				end.put(num, end.getOrDefault(num, 0) + 1);
			}
			// Інакше пробуємо створити нову послідовність num,num+1,num+2
			else if (count.getOrDefault(num + 1, 0) > 0 && count.getOrDefault(num + 2, 0) > 0) {
				count.put(num + 1, count.get(num + 1) - 1);
				count.put(num + 2, count.get(num + 2) - 1);
				end.put(num + 2, end.getOrDefault(num + 2, 0) + 1);
			}
			else {
				return false;
			}
		}
		
		return true;
	}
}
