package Problem_List.Q216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int n, int start) {
        // Якщо сума рівна n і кількість чисел рівна k
        if (n == 0 && combination.size() == k) {
            result.add(new ArrayList<>(combination)); // Додаємо копію комбінації
            return;
        }
        // Якщо сума перевищила n або кількість чисел більша за k
        if (n < 0 || combination.size() > k) {
            return;
        }

        // Ітерація по числах від start до 9
        for (int i = start; i <= 9; i++) {
            combination.add(i); // Додаємо число в комбінацію
            backtrack(result, combination, k, n - i, i + 1); // Рекурсивний виклик
            combination.remove(combination.size() - 1); // Відкочуємося назад
        }
    }
}

