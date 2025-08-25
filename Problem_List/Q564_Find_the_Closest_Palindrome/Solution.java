package Problem_List.Q564_Find_the_Closest_Palindrome;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public String nearestPalindromic(String n) {
		long num = Long.parseLong(n);
		int len = n.length();
		Set<Long> candidates = new HashSet<>();
		
		// Крайні випадки
		candidates.add((long)Math.pow(10, len - 1) - 1); // 999, 99, 9
		candidates.add((long)Math.pow(10, len) + 1);     // 1001, 10001
		
		long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
		
		for (long i = prefix - 1; i <= prefix + 1; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			String half = sb.toString();
			
			if (len % 2 == 0) {
				sb.append(new StringBuilder(half).reverse());
			} else {
				sb.append(new StringBuilder(half.substring(0, half.length() - 1)).reverse());
			}
			
			long candidate = Long.parseLong(sb.toString());
			candidates.add(candidate);
		}
		
		long closest = -1;
		for (long cand : candidates) {
			if (cand == num) continue;
			if (closest == -1 ||
					Math.abs(cand - num) < Math.abs(closest - num) ||
					(Math.abs(cand - num) == Math.abs(closest - num) && cand < closest)) {
				closest = cand;
			}
		}
		
		return String.valueOf(closest);
	}
}

