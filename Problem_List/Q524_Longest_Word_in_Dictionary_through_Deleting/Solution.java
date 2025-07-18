package Problem_List.Q524_Longest_Word_in_Dictionary_through_Deleting;

import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";

        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > result.length() ||
                        (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
    }

    private boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) i++;
            j++;
        }
        return i == word.length();
    }
}

