package Problem_List.Q459_Repeated_Substring_Pattern;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String trimmed = doubled.substring(1, doubled.length() - 1);
        return trimmed.contains(s);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.repeatedSubstringPattern("abab")); // true
        System.out.println(sol.repeatedSubstringPattern("aba"));  // false
        System.out.println(sol.repeatedSubstringPattern("abcabcabcabc")); // true
        System.out.println(sol.repeatedSubstringPattern("a")); // false
    }
}

