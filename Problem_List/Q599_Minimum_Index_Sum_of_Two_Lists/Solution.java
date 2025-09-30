package Problem_List.Q599_Minimum_Index_Sum_of_Two_Lists;

import java.util.*;

class Solution {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		int minSum = Integer.MAX_VALUE;
		
		// Зберігаємо індекси з list1
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		
		// Перевіряємо спільні елементи з list2
		for (int j = 0; j < list2.length; j++) {
			String word = list2[j];
			if (map.containsKey(word)) {
				int i = map.get(word);
				int sum = i + j;
				
				if (sum < minSum) {
					result.clear();
					result.add(word);
					minSum = sum;
				} else if (sum == minSum) {
					result.add(word);
				}
			}
		}
		
		return result.toArray(new String[0]);
	}
}
