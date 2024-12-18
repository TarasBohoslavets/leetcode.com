package Problem_List.Q210_Course_Schedule_II;

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Побудова графа
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        // Стани вузлів: 0 - невідвіданий, 1 - у процесі, 2 - завершений
        int[] state = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(graph, state, result, i)) {
                    return new int[0]; // Якщо знайдено цикл
                }
            }
        }

        // Результат у зворотному порядку
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(List<List<Integer>> graph, int[] state, List<Integer> result, int node) {
        if (state[node] == 1) return false; // Цикл
        if (state[node] == 2) return true;  // Вже завершений вузол

        state[node] = 1; // Помічаємо вузол як оброблюваний
        for (int neighbor : graph.get(node)) {
            if (!dfs(graph, state, result, neighbor)) {
                return false;
            }
        }

        state[node] = 2; // Помічаємо вузол як завершений
        result.add(node); // Додаємо вузол до результату
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses1, prerequisites1))); // Вивід: [0, 1]

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses2, prerequisites2))); // Вивід: [0, 2, 1, 3]

        int numCourses3 = 1;
        int[][] prerequisites3 = {};
        System.out.println(Arrays.toString(solution.findOrder(numCourses3, prerequisites3))); // Вивід: [0]
    }
}

