package Problem_List.Q670_Maximum_Swap;

class Solution {
	public int maximumSwap(int num) {
		char[] digits = Integer.toString(num).toCharArray();
		int n = digits.length;
		
		// Запам'ятати останню позицію кожної цифри
		int[] last = new int[10];
		for (int i = 0; i < n; i++) {
			last[digits[i] - '0'] = i;
		}
		
		// Шукаємо можливість для swap
		for (int i = 0; i < n; i++) {
			int d = digits[i] - '0';
			// шукаємо більшу цифру справа
			for (int bigger = 9; bigger > d; bigger--) {
				if (last[bigger] > i) {
					// міняємо місцями
					char temp = digits[i];
					digits[i] = digits[last[bigger]];
					digits[last[bigger]] = temp;
					return Integer.parseInt(new String(digits));
				}
			}
		}
		
		return num; // якщо перестановка не потрібна
	}
}