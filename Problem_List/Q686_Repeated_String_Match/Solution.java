package Problem_List.Q686_Repeated_String_Match;

class Solution {
	public int repeatedStringMatch(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		// повторюємо, поки довжина не стане >= b.length
		while (sb.length() < b.length()) {
			sb.append(a);
			count++;
		}
		
		// перевірка
		if (sb.indexOf(b) != -1) return count;
		
		// ще один повтор для перекриття
		sb.append(a);
		count++;
		if (sb.indexOf(b) != -1) return count;
		
		return -1;
	}
}
