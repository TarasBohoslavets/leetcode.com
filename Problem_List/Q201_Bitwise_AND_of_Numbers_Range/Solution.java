package Problem_List.Q201_Bitwise_AND_of_Numbers_Range;

/*
* Пояснення:
* Щоб знайти побітове AND для всіх чисел у діапазоні, зсуваємо обидва числа вправо, доки вони не стануть рівними.
* Кількість зсувів дає змогу знайти спільний префікс.
Зсув вправо:
Якщо числа відрізняються у старших бітах, то всі молодші біти анулюються при операції AND.
Завершення циклу:
Цикл зупиняється, коли числа збігаються, що означає, що вони мають спільний префікс, який є результатом.
* */

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // Поки числа не рівні
        while (left < right) {
            // Зсуваємо числа вправо, щоб знайти спільний префікс
            right = right & (right - 1);
        }
        return left & right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        System.out.println(solution.rangeBitwiseAnd(5, 7)); // Виведе: 4

        // Приклад 2
        System.out.println(solution.rangeBitwiseAnd(0, 0)); // Виведе: 0

        // Приклад 3
        System.out.println(solution.rangeBitwiseAnd(1, 2147483647)); // Виведе: 0
    }
}
