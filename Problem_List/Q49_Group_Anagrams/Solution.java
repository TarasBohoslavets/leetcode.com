package Problem_List.Q49_Group_Anagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Сортуємо символи в рядку
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // Додаємо рядок до відповідної групи
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }

        // Повертаємо значення мапи у вигляді списку списків
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String[] example1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(example1));

        // Example 2
        String[] example2 = {""};
        System.out.println(solution.groupAnagrams(example2));

        // Example 3
        String[] example3 = {"a"};
        System.out.println(solution.groupAnagrams(example3));
    }
}