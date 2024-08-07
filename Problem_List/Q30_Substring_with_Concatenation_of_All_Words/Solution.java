package Problem_List.Q30_Substring_with_Concatenation_of_All_Words;

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int substringLength = wordLength * wordCount;

        if (s.length() < substringLength) {
            return result;
        }

        // Створення частотної мапи для слів
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> currentMap = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordMap.containsKey(word)) {
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    currentMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        List<Integer> result1 = sol.findSubstring(s1, words1);
        System.out.println("Expected: [0, 9], Actual: " + result1);

        // Example 2
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        List<Integer> result2 = sol.findSubstring(s2, words2);
        System.out.println("Expected: [], Actual: " + result2);

        // Example 3
        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};
        List<Integer> result3 = sol.findSubstring(s3, words3);
        System.out.println("Expected: [6, 9, 12], Actual: " + result3);
    }
}
