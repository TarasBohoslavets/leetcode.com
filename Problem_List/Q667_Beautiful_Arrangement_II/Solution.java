package Problem_List.Q667_Beautiful_Arrangement_II;

import java.util.*;

class Solution {
	public int[] constructArray(int n, int k) {
		int[] res = new int[n];
		int left = 1, right = n;
		int index = 0;
		
		// Створюємо перші k різних різниць
		while (k > 0) {
			if (k % 2 == 1) {
				res[index++] = left++;
			} else {
				res[index++] = right--;
			}
			k--;
		}
		
		// Заповнюємо залишок послідовно
		if (index > 0 && res[index - 1] == left - 1) {
			while (left <= right) {
				res[index++] = left++;
			}
		} else {
			while (left <= right) {
				res[index++] = right--;
			}
		}
		
		return res;
	}
}