package Problem_List.Q493_Reverse_Pairs;

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // Функція mergeSort виконує модифікований злиттєвий сортування
    // та підраховує кількість "зворотних пар" у масиві
    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0; // Базовий випадок: один елемент — немає пар

        int mid = (left + right) / 2;

        // Рекурсивно підраховуємо пари в лівій і правій частинах
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        // Підраховуємо зворотні пари між лівою і правою частиною
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1); // додаємо кількість валідних j для поточного i
        }

        // Об'єднуємо дві відсортовані частини
        merge(nums, left, mid, right);
        return count;
    }

    // Функція для злиття двох відсортованих підмасивів nums[left..mid] і nums[mid+1..right]
    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // тимчасовий масив для збереження результату злиття
        int i = left, j = mid + 1, k = 0;

        // Зливаємо у відсортованому порядку
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }

        // Додаємо залишки елементів, якщо є
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        // Копіюємо об'єднаний відсортований масив назад у nums
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 3, 2, 3, 1};
        int result1 = sol.reversePairs(nums1);
        System.out.println("Example 1:");
        System.out.println("Input: [1, 3, 2, 3, 1]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 2\n");

        int[] nums2 = {2, 4, 3, 5, 1};
        int result2 = sol.reversePairs(nums2);
        System.out.println("Example 2:");
        System.out.println("Input: [2, 4, 3, 5, 1]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 3");
    }
}

