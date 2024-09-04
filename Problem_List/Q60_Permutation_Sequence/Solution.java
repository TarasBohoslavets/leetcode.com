package Problem_List.Q60_Permutation_Sequence;

import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        // Створюємо список для зберігання цифр
        List<Integer> numbers = new ArrayList<>();
        // Створюємо факторіал для n-1
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Заповнюємо список числами від 1 до n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Зміщуємо k на 1 (оскільки індексація у масивах починається з 0)
        k--;

        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial[i];
        }

        return sb.toString();
    }
}

