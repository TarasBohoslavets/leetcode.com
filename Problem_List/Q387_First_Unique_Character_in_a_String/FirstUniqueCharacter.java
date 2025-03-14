package Problem_List.Q387_First_Unique_Character_in_a_String;

import java.util.HashMap;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();

        // 1. Підрахунок частоти входження символів
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // 2. Пошук першого унікального символу
        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // Якщо немає унікальних символів
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));      // Output: 0
        System.out.println(firstUniqChar("loveleetcode")); // Output: 2
        System.out.println(firstUniqChar("aabb"));         // Output: -1
    }
}

