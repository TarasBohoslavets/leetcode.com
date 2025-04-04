package Problem_List.Q409_Longest_Palindrome;

import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128]; // ASCII таблиця

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int freq : count) {
            length += (freq / 2) * 2; // додаємо тільки парну частину
            if (freq % 2 == 1) {
                hasOdd = true;
            }
        }

        // Якщо хоча б одна літера має непарну кількість – додаємо 1 в центр
        return hasOdd ? length + 1 : length;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("abccccdd")); // 7
        System.out.println(sol.longestPalindrome("a"));        // 1
        System.out.println(sol.longestPalindrome("Aa"));       // 1
    }
}

