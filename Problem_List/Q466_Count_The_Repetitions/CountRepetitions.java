package Problem_List.Q466_Count_The_Repetitions;

public class CountRepetitions {

    /**
     * Метод countRepetitions повертає максимальне число m,
     * таке що str2, повторений m разів, можна отримати зі str1.
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;

        int s1Len = s1.length(), s2Len = s2.length();
        int[] repeatCount = new int[n1 + 1]; // Скільки разів s2 входить до цього моменту
        int[] nextIndex = new int[n1 + 1];   // Позиція в s2 після перегляду i s1

        int j = 0, count = 0;

        for (int i = 1; i <= n1; i++) {
            for (int k = 0; k < s1Len; k++) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    j++;
                    if (j == s2Len) {
                        j = 0;
                        count++; // Знайдено ще один s2
                    }
                }
            }
            repeatCount[i] = count;
            nextIndex[i] = j;

            // Перевірка на цикл
            for (int start = 0; start < i; start++) {
                if (nextIndex[start] == j) {
                    // Цикл знайдено
                    int prefixCount = repeatCount[start];
                    int patternCount = ((n1 - start) / (i - start)) * (repeatCount[i] - repeatCount[start]);
                    int suffixCount = repeatCount[start + (n1 - start) % (i - start)] - repeatCount[start];

                    return (prefixCount + patternCount + suffixCount) / n2;
                }
            }
        }

        return repeatCount[n1] / n2;
    }

    public static void main(String[] args) {
        CountRepetitions cr = new CountRepetitions();

        // Приклад 1: s1 = "acb", n1 = 4, s2 = "ab", n2 = 2
        int result1 = cr.getMaxRepetitions("acb", 4, "ab", 2);
        System.out.println("Результат 1: " + result1); // Очікується 2

        // Приклад 2: s1 = "acb", n1 = 1, s2 = "acb", n2 = 1
        int result2 = cr.getMaxRepetitions("acb", 1, "acb", 1);
        System.out.println("Результат 2: " + result2); // Очікується 1
    }
}
