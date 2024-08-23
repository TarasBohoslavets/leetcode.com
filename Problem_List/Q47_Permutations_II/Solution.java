package Problem_List.Q47_Permutations_II;

/*
Сортування: Arrays.sort(nums); — Сортуємо вхідний масив, щоб дублікати були розташовані поряд, що дозволяє нам уникати їх під час генерації перестановок.
Масив used: boolean[] used = new boolean[nums.length]; — Масив для відстеження, які елементи масиву вже були використані в поточній перестановці.
Метод backtrack: Це основний метод, що відповідає за генерацію перестановок. Він перевіряє кожен елемент масиву і додає його до тимчасового списку tempList,
якщо він ще не використаний або не є дублікатом.
Перевірка дубліката:
if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
Це умова, яка пропускає дублікати, якщо поточний елемент є таким самим, як і попередній, і попередній не був використаний.
Додавання результату: result.add(new ArrayList<>(tempList)); — Якщо тимчасовий список tempList має ту ж довжину, що і вхідний масив nums,
ми додаємо його копію до списку результатів result.
Таким чином, ми отримуємо всі можливі унікальні перестановки масиву з дублікатами.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Сортуємо масив, щоб уникати дублікати
        boolean[] used = new boolean[nums.length]; // Масив для відстеження використаних елементів
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Додаємо копію поточної перестановки до результату
        } else {
            for (int i = 0; i < nums.length; i++) {
                // Уникаємо дублювання
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
