package Problem_List.Q457_Circular_Array_Loop;
/*
Ми шукаємо цикл довжиною більше 1, у якому всі переходи йдуть в одному напрямку
(всі + або всі -) по циклічному масиву.
 */

public class Solution {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Якщо вже відмічений як нециклічний
            if (nums[i] == 0) continue;

            // slow і fast починаються з одного індексу
            int slow = i, fast = i;

            // напрямок руху: вперед або назад
            boolean isForward = nums[i] > 0;

            while (true) {
                // Отримуємо наступний індекс для slow
                slow = nextIndex(nums, isForward, slow);
                // Отримуємо 2 наступних індекси для fast
                fast = nextIndex(nums, isForward, fast);
                if (fast != -1)
                    fast = nextIndex(nums, isForward, fast);

                if (slow == -1 || fast == -1 || slow == fast)
                    break;
            }

            if (slow != -1 && slow == fast) return true;

            // Маркуємо всі елементи в цьому шляху як 0 (не частина циклу)
            int idx = i;
            int val = nums[i];
            while (true) {
                int next = nextIndex(nums, val > 0, idx);
                if (next == -1) break;
                nums[idx] = 0;
                idx = next;
            }
        }

        return false;
    }

    // Метод для отримання наступного індексу в циклі
    private int nextIndex(int[] nums, boolean isForward, int currentIndex) {
        boolean direction = nums[currentIndex] > 0;
        if (isForward != direction) return -1;

        int n = nums.length;
        int nextIndex = ((currentIndex + nums[currentIndex]) % n + n) % n;  // Правильне модулювання
        if (nextIndex == currentIndex) return -1; // цикл з 1 елемента

        return nextIndex;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2, -1, 1, 2, 2};
        System.out.println("Example 1 (Expected: true): " + sol.circularArrayLoop(nums1));

        int[] nums2 = {-1, -2, -3, -4, -5, 6};
        System.out.println("Example 2 (Expected: false): " + sol.circularArrayLoop(nums2));

        int[] nums3 = {1, -1, 5, 1, 4};
        System.out.println("Example 3 (Expected: true): " + sol.circularArrayLoop(nums3));

        int[] nums4 = {1, 1, 1, 1, 1};
        System.out.println("Always forward (Expected: true): " + sol.circularArrayLoop(nums4));
    }
}
