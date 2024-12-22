package Problem_List.Q214_Shortest_Palindrome;

class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        // Створюємо розширений рядок
        String temp = s + "#" + new StringBuilder(s).reverse().toString();

        // Обчислюємо функцію префіксів для temp
        int[] prefix = computePrefix(temp);

        // Довжина найбільшого суфікса, який також є префіксом
        int palindromeLength = prefix[temp.length() - 1];

        // Символи, які потрібно додати на початок
        String suffixToAdd = s.substring(palindromeLength);

        return new StringBuilder(suffixToAdd).reverse().toString() + s;
    }

    // Обчислення функції префіксів для KMP
    private int[] computePrefix(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefix[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            prefix[i] = j;
        }

        return prefix;
    }
}

