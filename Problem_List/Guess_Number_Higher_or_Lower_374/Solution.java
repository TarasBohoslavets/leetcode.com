package Problem_List.Guess_Number_Higher_or_Lower_374;

// Абстрактний клас GuessGame з методом guess
abstract class GuessGame {
    abstract int guess(int num);
}

// Клас Solution, який успадковує GuessGame
public abstract class Solution extends GuessGame {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid;
            } else if (res == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;  // Якщо число не знайдено (хоча згідно з умовою задачі, це не має статися)
    }

    public static void main(String[] args) {
        // Створення анонімного класу для тестування
        Solution solution = new Solution() {
            @Override
            int guess(int num) {
                int pick = 6;  // Приклад загаданого числа для тестування
                if (num > pick) {
                    return -1;
                } else if (num < pick) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        int n = 10;
        System.out.println(solution.guessNumber(n));  // Має повернути 6
    }
}
