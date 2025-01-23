package Problem_List.Q299_Bulls_and_Cows;
/*
Суть гри "Бики та Корови"
Уяви, що у нас є секретне число (secret) і є число, яке ти намагаєшся вгадати (guess).

Твоє завдання — визначити:

"Биків" (bulls): це цифри в guess, які:

Знаходяться на тому самому місці, що й у secret.
Повністю збігаються з цифрою в secret.
"Корови" (cows): це цифри в guess, які:

Присутні в secret, але не стоять на тій самій позиції.
Результат гри записується у форматі:
xAyB,
де:

x — кількість "биків" (bulls),
y — кількість "корів" (cows).

* */
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0; // Кількість биків
        int cows = 0; // Кількість корів
        int[] secretCounts = new int[10]; // Частота цифр у secret
        int[] guessCounts = new int[10]; // Частота цифр у guess

        // Підрахунок биків і збір частот цифр
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++; // Бик знайдений
            } else {
                secretCounts[secret.charAt(i) - '0']++;
                guessCounts[guess.charAt(i) - '0']++;
            }
        }

        // Підрахунок корів
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCounts[i], guessCounts[i]); // Мінімум частот
        }

        return bulls + "A" + cows + "B"; // Формат "xAyB"
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        String secret1 = "1807";
        String guess1 = "7810";
        System.out.println(solution.getHint(secret1, guess1)); // Вихід: "1A3B"

        // Приклад 2
        String secret2 = "1123";
        String guess2 = "0111";
        System.out.println(solution.getHint(secret2, guess2)); // Вихід: "1A1B"

        // Додатковий тест
        String secret3 = "1234";
        String guess3 = "4321";
        System.out.println(solution.getHint(secret3, guess3)); // Вихід: "0A4B"
    }
}
