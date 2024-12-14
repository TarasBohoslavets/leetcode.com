package Problem_List.Q204_Count_Primes;

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0; // Немає простих чисел менших за 2
        }

        // Створюємо булевий масив для визначення простоти числа
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true; // Початково вважаємо всі числа простими
        }

        // Використовуємо метод Решето Ератосфена
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false; // Помічаємо кратні числа як не прості
                }
            }
        }

        // Підраховуємо кількість простих чисел
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        System.out.println(solution.countPrimes(10)); // Виведе: 4

        // Приклад 2
        System.out.println(solution.countPrimes(0)); // Виведе: 0

        // Приклад 3
        System.out.println(solution.countPrimes(1)); // Виведе: 0
    }
}

