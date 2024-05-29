package Problem_List.Single_Number;

/*
1. **Ініціалізація**: Ми починаємо з `result = 0`.
2. **Перебір масиву**: Ми проходимося по кожному елементу масиву `nums` і виконуємо операцію XOR з `result`.
3. **Повернення результату**: Після завершення циклу в `result` залишиться те число, яке з'являється один раз у масиві.
Підхід з використанням оператора XOR є найефективнішим рішенням для цієї задачі,
оскільки він забезпечує лінійну часову складність O(n) та постійну просторову складність O(1).
*/
public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Приклад 1
        int[] nums1 = {2, 2, 1};
        System.out.println ( solution.singleNumber ( nums1 ) ); // Вивід: 1

        // Приклад 2
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println ( solution.singleNumber ( nums2 ) ); // Вивід: 4

        // Приклад 3
        int[] nums3 = {1};
        System.out.println ( solution.singleNumber ( nums3 ) ); // Вивід: 1
    }

    public int singleNumber ( int[] nums ) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // Виконуємо XOR для кожного числа в масиві
        }
        return result; // Повертаємо залишкове число
    }
}
