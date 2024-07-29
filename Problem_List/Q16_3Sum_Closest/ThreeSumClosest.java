package Problem_List.Q16_3Sum_Closest;

/*
Пояснення
Сортування масиву: Вхідний масив сортується для зручності використання двох вказівників.
Основний цикл: Проходимо по масиву і для кожного елемента запускаємо двохвказівниковий пошук.
Пошук з двома вказівниками: Використовуємо два вказівники, що рухаються в протилежних напрямках для пошуку двох чисел,
сума яких разом з поточним числом максимально близька до цільового значення.
Оновлення найближчої суми: Підтримуємо змінну closestSum, яка зберігає найближчу до цільового значення суму.
Рух вказівників: Якщо поточна сума менша за цільову, зсуваємо лівий вказівник вправо, щоб збільшити суму.
Якщо більша, зсуваємо правий вказівник вліво, щоб зменшити суму.
Цей підхід гарантує, що ми знайдемо найближчу до цільової суму трьох чисел у масиві за час O(n^2),
що є прийнятним для даного діапазону вхідних даних.
* */

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // Ініціалізуємо найближчу суму першими трьома елементами

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return sum; // Якщо знайшли точний збіг, повертаємо його
                }

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum; // Оновлюємо найближчу суму, якщо поточна сума ближча до цільової
                }

                if (sum < target) {
                    left++; // Зсуваємо лівий вказівник вправо, щоб збільшити суму
                } else {
                    right--; // Зсуваємо правий вказівник вліво, щоб зменшити суму
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();

        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println(solution.threeSumClosest(nums1, target1)); // Виведе: 2

        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println(solution.threeSumClosest(nums2, target2)); // Виведе: 0
    }
}

