package Problem_List.Q520_Detect_Capital;

class Solution {
    public boolean detectCapitalUse(String word) {
        return word.equals(word.toUpperCase()) ||       // Всі літери великі (e.g. "USA")
                word.equals(word.toLowerCase()) ||       // Всі літери малі (e.g. "leetcode")
                Character.isUpperCase(word.charAt(0)) && // Перша літера велика...
                        word.substring(1).equals(word.substring(1).toLowerCase()); // ...решта малі (e.g. "Google")
    }
}

