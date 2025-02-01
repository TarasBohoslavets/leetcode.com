package Problem_List.Q315_Count_of_Smaller_Numbers_After_Self;

import java.util.*;

class Solution {
    // Допоміжний клас для збереження значення та його початкового індексу
    class Pair {
        int value, index;
        Pair(int v, int i) { value = v; index = i; }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n]; // Масив для збереження результату
        Arrays.fill(result, 0); // Заповнюємо 0, оскільки спочатку менших елементів немає

        Pair[] arr = new Pair[n]; // Створюємо масив пар (значення, індекс)
        for (int i = 0; i < n; i++) arr[i] = new Pair(nums[i], i);

        // Викликаємо модифіковане сортування злиттям
        mergeSort(arr, result, 0, n - 1);
        return Arrays.asList(result); // Повертаємо список результатів
    }

    // Функція сортування злиттям (Merge Sort)
    private void mergeSort(Pair[] arr, Integer[] result, int left, int right) {
        if (left >= right) return; // Базовий випадок: один елемент - уже відсортовано

        int mid = (left + right) / 2;
        mergeSort(arr, result, left, mid); // Рекурсивно сортуємо ліву частину
        mergeSort(arr, result, mid + 1, right); // Рекурсивно сортуємо праву частину
        merge(arr, result, left, mid, right); // Об'єднуємо дві частини
    }

    // Функція для злиття двох відсортованих підмасивів
    private void merge(Pair[] arr, Integer[] result, int left, int mid, int right) {
        List<Pair> temp = new ArrayList<>();
        int i = left, j = mid + 1, countRight = 0; // Лічильник менших елементів у правій частині

        // Порівнюємо та зливаємо два відсортовані підмасиви
        while (i <= mid && j <= right) {
            if (arr[i].value > arr[j].value) {
                countRight++;  // Якщо правий менший за лівий - це означає, що знайдено менший елемент
                temp.add(arr[j++]); // Додаємо менший елемент до списку
            } else {
                result[arr[i].index] += countRight; // Додаємо до результату знайдені менші елементи
                temp.add(arr[i++]); // Додаємо поточний елемент до списку
            }
        }

        // Додаємо залишкові елементи з лівої частини
        while (i <= mid) {
            result[arr[i].index] += countRight; // Всі залишкові елементи отримують countRight
            temp.add(arr[i++]);
        }

        // Додаємо залишкові елементи з правої частини
        while (j <= right) temp.add(arr[j++]);

        // Копіюємо відсортовані елементи назад у вихідний масив
        for (int k = left; k <= right; k++) arr[k] = temp.get(k - left);
    }

    // Головний метод для тестування
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {5, 2, 6, 1};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.countSmaller(nums1));

        int[] nums2 = {-1};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.countSmaller(nums2));

        int[] nums3 = {-1, -1};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.countSmaller(nums3));

        int[] nums4 = {10, 9, 8, 7, 6, 5};
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Output: " + solution.countSmaller(nums4));

        int[] nums5 = {1, 2, 3, 4, 5, 6};
        System.out.println("Input: " + Arrays.toString(nums5));
        System.out.println("Output: " + solution.countSmaller(nums5));
    }
}
