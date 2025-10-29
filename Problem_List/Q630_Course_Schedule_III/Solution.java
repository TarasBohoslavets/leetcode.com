package Problem_List.Q630_Course_Schedule_III;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, (a, b) -> a[1] - b[1]); // Сортуємо за дедлайном
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int time = 0;
		
		for (int[] course : courses) {
			int duration = course[0], lastDay = course[1];
			time += duration;
			maxHeap.offer(duration);
			
			if (time > lastDay) {
				time -= maxHeap.poll(); // Видаляємо найдовший курс, щоб встигнути
			}
		}
		
		return maxHeap.size(); // Кількість курсів, які вдалося пройти
	}
}

