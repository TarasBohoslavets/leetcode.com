package Problem_List.Q207_Course_Schedule;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Побудова графа та масиву вхідних ребер (indegree)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Додаємо всі курси без передумов у чергу
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Лічильник завершених курсів
        int completedCourses = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            // Зменшуємо вхідні ребра для залежних курсів
            for (int neighbor : graph.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Якщо всі курси завершені, повертаємо true
        return completedCourses == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();

        // Приклад 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(cs.canFinish(numCourses1, prerequisites1)); // Виведе: true

        // Приклад 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(cs.canFinish(numCourses2, prerequisites2)); // Виведе: false
    }
}
