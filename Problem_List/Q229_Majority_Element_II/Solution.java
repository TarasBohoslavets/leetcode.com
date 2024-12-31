package Problem_List.Q229_Majority_Element_II;

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;

        // Перший прохід: визначення двох потенційних кандидатів
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Другий прохід: перевірка частоти кандидатів
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.majorityElement(new int[]{3, 2, 3})); // Вивід: [3]
        System.out.println(solution.majorityElement(new int[]{1}));       // Вивід: [1]
        System.out.println(solution.majorityElement(new int[]{1, 2}));    // Вивід: [1, 2]
        System.out.println(solution.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2})); // Вивід: [1, 2]
    }
}

