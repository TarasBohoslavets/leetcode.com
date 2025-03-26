package Problem_List.Q399_Evaluate_Division;

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Створюємо граф у вигляді мапи: ключ - змінна, значення - її сусіди та відповідні коефіцієнти
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Додаємо рівняння в граф
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            // Якщо вузол ще не створений, додаємо його
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            // Додаємо ребро a -> b з вагою value
            graph.get(a).put(b, value);
            // Додаємо обернене ребро b -> a з вагою 1 / value
            graph.get(b).put(a, 1.0 / value);
        }

        // Масив для збереження результатів запитів
        double[] result = new double[queries.size()];

        // Обробка кожного запиту за допомогою DFS
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            // Викликаємо DFS для знаходження значення виразу start / end
            result[i] = dfs(start, end, graph, new HashSet<>());
        }
        return result;
    }

    private double dfs(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
        // Якщо один з вузлів відсутній у графі, повертаємо -1.0
        if (!graph.containsKey(start) || !graph.containsKey(end)) return -1.0;
        // Якщо шукаємо шлях від вузла до самого себе, повертаємо 1.0 (A / A = 1)
        if (start.equals(end)) return 1.0;

        // Додаємо вузол у множину відвіданих, щоб уникнути циклів
        visited.add(start);

        // Проходимося по сусідах поточного вузла
        Map<String, Double> neighbors = graph.get(start);
        for (String neighbor : neighbors.keySet()) {
            if (!visited.contains(neighbor)) { // Якщо вузол ще не відвіданий
                double weight = neighbors.get(neighbor); // Отримуємо вагу ребра
                double result = dfs(neighbor, end, graph, visited); // Рекурсивний виклик DFS

                // Якщо знайдено шлях до кінцевого вузла, повертаємо обчислене значення
                if (result != -1.0) {
                    return result * weight;
                }
            }
        }

        // Якщо шлях не знайдено, повертаємо -1.0
        return -1.0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        List<List<String>> equations1 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        System.out.println(Arrays.toString(solution.calcEquation(equations1, values1, queries1)));
        // Очікуваний результат: [6.0, 0.5, -1.0, 1.0, -1.0]

        // Приклад 2
        List<List<String>> equations2 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c"),
                Arrays.asList("bc", "cd")
        );
        double[] values2 = {1.5, 2.5, 5.0};
        List<List<String>> queries2 = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("c", "b"),
                Arrays.asList("bc", "cd"),
                Arrays.asList("cd", "bc")
        );

        System.out.println(Arrays.toString(solution.calcEquation(equations2, values2, queries2)));
        // Очікуваний результат: [3.75, 0.4, 5.0, 0.2]

        // Приклад 3
        List<List<String>> equations3 = Arrays.asList(
                Arrays.asList("a", "b")
        );
        double[] values3 = {0.5};
        List<List<String>> queries3 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "c"),
                Arrays.asList("x", "y")
        );

        System.out.println(Arrays.toString(solution.calcEquation(equations3, values3, queries3)));
        // Очікуваний результат: [0.5, 2.0, -1.0, -1.0]
    }
}