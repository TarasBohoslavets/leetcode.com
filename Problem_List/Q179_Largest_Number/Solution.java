package Problem_List.Q179_Largest_Number;

import java.util.Arrays;

public class Solution {
//    public static String largestNumber(int[] nums) {
//        // Convert integers to strings for custom sorting
//        String[] strNums = Arrays.stream(nums)
//                .mapToObj(String::valueOf)
//                .toArray(String[]::new);
//
//        // Sort using custom comparator
//        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
//
//        // If the largest number after sorting is "0", the entire result is "0"
//        if (strNums[0].equals("0")) {
//            return "0";
//        }
//
//        // Concatenate sorted strings to form the largest number
//        StringBuilder largestNumber = new StringBuilder();
//        for (String num : strNums) {
//            largestNumber.append(num);
//        }
//
//        return largestNumber.toString();
//    }

    public static String largestNumber(int[] nums) {
        // Створення масиву строк для зберігання чисел у вигляді строк
        String[] numString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // Конвертація кожного числа з масиву nums у строку
            numString[i] = Integer.toString(nums[i]);
        }

        // Сортування масиву строк за допомогою кастомного компаратора
        Arrays.sort(numString, (a, b) -> (b + a).compareTo(a + b));
        // Пояснення компаратора:
        // - Ми порівнюємо комбінації "b+a" та "a+b".
        // - Наприклад, для "3" і "30", порівнюються "303" і "330".
        // - Комбінація, яка дає більше число ("330"), йде першою.

        // Якщо після сортування найвище значення - "0",
        // це означає, що всі числа в масиві дорівнюють нулю.
        if (numString[0].equals("0")) {
            return "0"; // Повертаємо "0", щоб уникнути зайвих нулів у результаті.
        }

        // Використовуємо StringBuilder для формування кінцевого результату
        StringBuilder largestNum = new StringBuilder();
        for (String numStr : numString) {
            // Додаємо кожну строку до результату
            largestNum.append(numStr);
        }

        // Повертаємо результат у вигляді строки
        return largestNum.toString();
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {10, 2};
        System.out.println(largestNumber(nums1)); // Output: "210"

        // Example 2
        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums2)); // Output: "9534330"
    }
}
