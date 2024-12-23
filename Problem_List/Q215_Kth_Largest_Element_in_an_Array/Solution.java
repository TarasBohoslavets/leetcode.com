package Problem_List.Q215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

//class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//
//        for (int num : nums) {
//            minHeap.add(num);
//            if (minHeap.size() > k) {
//                minHeap.poll(); // Видаляємо найменший елемент
//            }
//        }
//
//        return minHeap.peek(); // Повертаємо корінь кучи
//    }
//}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            maxheap.add(nums[i]);
        }
        int f = k - 1;
        while (f > 0) {
            maxheap.remove();
            f--;
        }

        return maxheap.peek();


    }
}
