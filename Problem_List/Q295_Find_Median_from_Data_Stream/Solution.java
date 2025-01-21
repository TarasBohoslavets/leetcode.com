package Problem_List.Q295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Для меншої половини чисел
    private PriorityQueue<Integer> minHeap; // Для більшої половини чисел

    public MedianFinder() {
        // Max-heap (для меншої половини)
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Min-heap (для більшої половини)
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Додаємо число до відповідної купи
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Балансуємо купи, якщо різниця в розмірах більше 1
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        // Якщо кількість чисел непарна
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        // Якщо кількість чисел парна
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }



    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        System.out.println("Adding numbers and finding medians:");

        medianFinder.addNum(1);
        System.out.println("Added 1. Current median: " + medianFinder.findMedian()); // Output: 1.0

        medianFinder.addNum(2);
        System.out.println("Added 2. Current median: " + medianFinder.findMedian()); // Output: 1.5

        medianFinder.addNum(3);
        System.out.println("Added 3. Current median: " + medianFinder.findMedian()); // Output: 2.0

        medianFinder.addNum(4);
        System.out.println("Added 4. Current median: " + medianFinder.findMedian()); // Output: 2.5

        medianFinder.addNum(5);
        System.out.println("Added 5. Current median: " + medianFinder.findMedian()); // Output: 3.0
    }
}


