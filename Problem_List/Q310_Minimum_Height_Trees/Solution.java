package Problem_List.Q310_Minimum_Height_Trees;

import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0); // Якщо лише один вузол, повертаємо його

        List<Integer> result = new ArrayList<>();
        List<Set<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Знайдемо початкові листки (степінь вузла == 1)
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // Видаляємо листки рівнями, поки не залишиться <= 2 вершини
        while (n > 2) {
            int size = leaves.size();
            n -= size;

            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                for (int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);
                    if (graph.get(neighbor).size() == 1) {
                        leaves.add(neighbor);
                    }
                }
            }
        }

        // Листки на останньому кроці - це і є центри дерева
        result.addAll(leaves);
        return result;
    }
}

