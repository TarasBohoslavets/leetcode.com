package Problem_List.Q636_Exclusive_Time_of_Functions;

import java.util.*;

class Solution {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] result = new int[n];
		Deque<Integer> stack = new ArrayDeque<>();
		int prevTime = 0;
		
		for (String log : logs) {
			String[] parts = log.split(":");
			int id = Integer.parseInt(parts[0]);
			String type = parts[1];
			int time = Integer.parseInt(parts[2]);
			
			if (type.equals("start")) {
				if (!stack.isEmpty()) {
					result[stack.peek()] += time - prevTime;
				}
				stack.push(id);
				prevTime = time;
			} else { // "end"
				result[stack.pop()] += time - prevTime + 1;
				prevTime = time + 1;
			}
		}
		
		return result;
	}
}