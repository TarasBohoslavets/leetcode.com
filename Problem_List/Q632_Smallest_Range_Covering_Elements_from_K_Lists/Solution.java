package Problem_List.Q632_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.*;

class Solution {
	public int[] smallestRange(List<List<Integer>> nums) {
		PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
		int max = Integer.MIN_VALUE;
		int start = 0, end = Integer.MAX_VALUE;
		
		// Ініціалізуємо купу першим елементом з кожного списку
		for (int i = 0; i < nums.size(); i++) {
			int val = nums.get(i).get(0);
			minHeap.offer(new Element(val, i, 0));
			max = Math.max(max, val);
		}
		
		while (minHeap.size() == nums.size()) {
			Element curr = minHeap.poll();
			if (max - curr.val < end - start || (max - curr.val == end - start && curr.val < start)) {
				start = curr.val;
				end = max;
			}
			
			// Перехід до наступного елемента в тому ж списку
			if (curr.idx + 1 < nums.get(curr.list).size()) {
				int nextVal = nums.get(curr.list).get(curr.idx + 1);
				minHeap.offer(new Element(nextVal, curr.list, curr.idx + 1));
				max = Math.max(max, nextVal);
			}
		}
		
		return new int[]{start, end};
	}
	
	static class Element {
		int val, list, idx;
		Element(int val, int list, int idx) {
			this.val = val;
			this.list = list;
			this.idx = idx;
		}
	}
}

