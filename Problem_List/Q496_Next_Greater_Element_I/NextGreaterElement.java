package Problem_List.Q496_Next_Greater_Element_I;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Використання HashMap для швидкого доступу до результатів
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Заповнюємо HashMap значеннями наступних більших елементів
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                greaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Заповнення відповіді для nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = greaterMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement solver = new NextGreaterElement();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = solver.nextGreaterElement(nums1, nums2);
        System.out.println(java.util.Arrays.toString(result)); // Очікуваний результат: [-1, 3, -1]

        int[] nums1b = {2, 4};
        int[] nums2b = {1, 2, 3, 4};
        int[] result2 = solver.nextGreaterElement(nums1b, nums2b);
        System.out.println(java.util.Arrays.toString(result2)); // Очікуваний результат: [3, -1]
    }
}

