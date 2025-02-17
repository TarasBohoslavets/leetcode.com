package Problem_List.Q336_Palindrome_Pairs;

import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> wordIndexMap = new HashMap<>();

        // 1. Заповнюємо мапу "слово -> індекс"
        for (int i = 0; i < words.length; i++) {
            wordIndexMap.put(words[i], i);
        }

        // 2. Перебираємо кожне слово і шукаємо пари
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();

            for (int j = 0; j <= len; j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                // 2.1 Якщо left паліндром і reverse(right) є в словнику
                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if (wordIndexMap.containsKey(reversedRight) && wordIndexMap.get(reversedRight) != i) {
                        result.add(Arrays.asList(wordIndexMap.get(reversedRight), i));
                    }
                }

                // 2.2 Якщо right паліндром і reverse(left) є в словнику
                if (isPalindrome(right) && right.length() > 0) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (wordIndexMap.containsKey(reversedLeft) && wordIndexMap.get(reversedLeft) != i) {
                        result.add(Arrays.asList(i, wordIndexMap.get(reversedLeft)));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs solution = new PalindromePairs();
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(solution.palindromePairs(words)); // [[0,1],[1,0],[3,2],[2,4]]
    }
}

