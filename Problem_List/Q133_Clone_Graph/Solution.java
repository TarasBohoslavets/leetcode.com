package Problem_List.Q133_Clone_Graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

class Solution {
    private Map<Node, Node> visited = new HashMap<>(); // Мапа для відстеження вже скопійованих вузлів

    public Node cloneGraph(Node node) {
        if (node == null) return null; // Якщо вузол порожній, повертаємо null

        // Якщо вузол вже був скопійований, повертаємо його
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Створюємо копію поточного вузла
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode); // Зберігаємо копію в мапі

        // Копіюємо всіх сусідів для поточного вузла
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode; // Повертаємо копію графа
    }
}

