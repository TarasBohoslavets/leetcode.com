package Problem_List.Q502_IPO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Об'єднуємо кожен проєкт у пару [minCapital, profit]
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }

        // Сортуємо проєкти за вимогою до капіталу
        Arrays.sort(projects, Comparator.comparingInt(p -> p.cost));

        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int index = 0;

        for (int i = 0; i < k; i++) {
            // Додаємо всі доступні проєкти в heap
            while (index < n && projects[index].cost <= w) {
                maxProfitHeap.offer(projects[index++].profit);
            }

            if (maxProfitHeap.isEmpty()) break;

            w += maxProfitHeap.poll(); // Обираємо найприбутковіший
        }

        return w;
    }

    static class Project {
        int profit, cost;

        Project(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }
    }
}
