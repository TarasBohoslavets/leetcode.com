package Problem_List.Q334_Increasing_Triplet_Subsequence;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Змінні для відстеження двох найменших чисел у масиві
        int first = Integer.MAX_VALUE;  // Найменше число (початково дуже велике)
        int second = Integer.MAX_VALUE; // Друге найменше число

        // Проходимо по всьому масиву
        for (int num : nums) {
            if (num <= first) {
                first = num;  // Оновлюємо найменше число
            } else if (num <= second) {
                second = num; // Оновлюємо друге найменше число
            } else {
                return true;  // Знайшли число більше за first і second → є трійка
            }
        }
        return false; // Якщо жодного збільшення не знайдено, повертаємо false
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Тестові приклади
        int[] test1 = {1, 2, 3, 4, 5};  // Очікуваний результат: true
        int[] test2 = {5, 4, 3, 2, 1};  // Очікуваний результат: false
        int[] test3 = {2, 1, 5, 0, 4, 6};  // Очікуваний результат: true
        int[] test4 = {20, 100, 10, 12, 5, 13};  // Очікуваний результат: true
        int[] test5 = {1, 1, 1, 1, 1};  // Очікуваний результат: false

        // Вивід результатів
        System.out.println(solution.increasingTriplet(test1)); // true
        System.out.println(solution.increasingTriplet(test2)); // false
        System.out.println(solution.increasingTriplet(test3)); // true
        System.out.println(solution.increasingTriplet(test4)); // true
        System.out.println(solution.increasingTriplet(test5)); // false
    }
}
