package Problem_List.Q89_Gray_Code;

import java.util.*;

public class Solution {
//    public List<Integer> grayCode(int n) {
//        // Створюємо список для збереження результатів
//        List<Integer> result = new ArrayList<>();
//
//        // Генеруємо Gray код для всіх чисел від 0 до 2^n - 1
//        for (int i = 0; i < (1 << n); i++) {
//            // Додаємо Gray код, який обчислюється як i XOR (i >> 1)
//            result.add(i ^ (i >> 1));
//        }
//
//        return result;
//    }

    public List<Integer> grayCode(int n) {
        // Створюємо список для збереження результатів
        List<Integer> ans = new ArrayList<>();
        ans.add(0);  // Починаємо з Gray коду для числа 0

        // Генеруємо Gray код для n бітів
        for (int i = 0; i < n; ++i) {
            // Проходимо по списку у зворотному порядку
            for (int j = ans.size() - 1; j >= 0; --j) {
                // Додаємо нові Gray коди, встановлюючи i-й біт в 1
                ans.add(ans.get(j) | 1 << i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int n1 = 2;
        System.out.println("Gray код для n = 2: " + solution.grayCode(n1));

        // Приклад 2
        int n2 = 1;
        System.out.println("Gray код для n = 1: " + solution.grayCode(n2));
    }
}

