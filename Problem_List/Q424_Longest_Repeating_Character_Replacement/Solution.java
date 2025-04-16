package Problem_List.Q424_Longest_Repeating_Character_Replacement;

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // частоти літер у поточному вікні
        int left = 0, right = 0;
        int maxCount = 0; // кількість найчастішої літери
        int maxLength = 0;

        while (right < s.length()) {
            // Додаємо нову літеру у вікно
            count[s.charAt(right) - 'A']++;
            // Оновлюємо найчастішу літеру
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // Якщо потрібно змінити більше ніж k символів — рухаємо left
            if (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Вікно допустиме, оновлюємо довжину
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("ABAB, k=2 → " + sol.characterReplacement("ABAB", 2));       // 4
        System.out.println("AABABBA, k=1 → " + sol.characterReplacement("AABABBA", 1)); // 4
    }
}

