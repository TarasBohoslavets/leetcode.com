package Problem_List.Q480_Sliding_Window_Median;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // Дві купи: low — макс-купа (найбільші елементи в лівій частині),
        // high — мін-купа (найменші елементи в правій частині)
        PriorityQueue<Integer> high = new PriorityQueue<>();
        PriorityQueue<Integer> low = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // HashMap для відкладеного видалення елементів, які вийшли з вікна
        HashMap<Integer, Integer> map = new HashMap<>();

        // Заповнюємо перші k елементів в low
        for (int i = 0; i < k; i++) {
            low.add(nums[i]);
        }

        // Переносимо k/2 найбільших з low в high для балансування
        for (int i = 0; i < k / 2; i++) {
            high.add(low.poll());
        }

        int i = k, index = 0;
        double[] res = new double[nums.length - k + 1];

        while (true) {
            // Додаємо медіану у результат
            if (k % 2 == 0) {
                res[index++] = ((double) low.peek() + (double) high.peek()) / 2;
            } else {
                res[index++] = low.peek();
            }

            // Виходимо з циклу, якщо всі вікна пройдені
            if (i >= nums.length) break;

            // Отримуємо число, що вийшло з вікна, і те, що увійшло
            int outNum = nums[i - k];
            int inNum = nums[i++];

            // Підраховуємо баланс між купами
            int balance = outNum <= low.peek() ? -1 : 1;
            map.put(outNum, map.getOrDefault(outNum, 0) + 1); // Позначаємо, що це число видаляється

            // Додаємо нове число до відповідної купи та оновлюємо баланс
            if (inNum <= low.peek()) {
                balance++;
                low.add(inNum);
            } else {
                balance--;
                high.add(inNum);
            }

            // Балансуємо купи
            if (balance < 0) {
                low.add(high.poll());
            } else if (balance > 0) {
                high.add(low.poll());
            }

            // Видаляємо позначені для видалення числа з вершин куп
            while (!low.isEmpty() && map.getOrDefault(low.peek(), 0) > 0) {
                int val = low.poll();
                map.put(val, map.get(val) - 1);
            }
            while (!high.isEmpty() && map.getOrDefault(high.peek(), 0) > 0) {
                int val = high.poll();
                map.put(val, map.get(val) - 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] result = sol.medianSlidingWindow(nums, k);

        System.out.println("Результат:");
        for (double d : result) {
            System.out.printf("%.5f ", d);
        }
    }
}
