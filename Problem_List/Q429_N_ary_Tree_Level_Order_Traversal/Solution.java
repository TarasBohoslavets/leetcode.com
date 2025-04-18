package Problem_List.Q429_N_ary_Tree_Level_Order_Traversal;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); // додаємо корінь до черги

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // кількість вузлів на поточному рівні
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll(); // дістаємо вузол з черги
                level.add(current.val); // додаємо його значення до рівня

                // додаємо всіх дітей цього вузла до черги
                if (current.children != null) {
                    for (Node child : current.children) {
                        queue.offer(child);
                    }
                }
            }

            result.add(level); // додаємо рівень до загального списку
        }

        return result;
    }
}

