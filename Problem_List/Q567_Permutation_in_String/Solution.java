package Problem_List.Q567_Permutation_in_String;

import java.util.Arrays;

class Solution {
	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) return false;
		
		int[] count1 = new int[26];
		int[] count2 = new int[26];
		
		// Заповнюємо частоти для s1 і першого вікна s2
		for (int i = 0; i < s1.length(); i++) {
			count1[s1.charAt(i) - 'a']++;
			count2[s2.charAt(i) - 'a']++;
		}
		
		// Перевірка першого вікна
		if (Arrays.equals(count1, count2)) return true;
		
		// Рухаємо вікно по s2
		for (int i = s1.length(); i < s2.length(); i++) {
			count2[s2.charAt(i) - 'a']++;                      // додаємо новий символ
			count2[s2.charAt(i - s1.length()) - 'a']--;        // прибираємо старий
			
			if (Arrays.equals(count1, count2)) return true;
		}
		
		return false;
	}
}
