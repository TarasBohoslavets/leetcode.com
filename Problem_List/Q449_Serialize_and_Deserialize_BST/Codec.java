package Problem_List.Q449_Serialize_and_Deserialize_BST;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Серіалізація: перетворюємо дерево у рядок (preorder traversal)
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString().trim(); // прибираємо зайвий пробіл в кінці
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(" ");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // Десеріалізація: відновлюємо дерево з рядка, знаючи що це BST
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<Integer> nodes = new LinkedList<>();
        for (String s : data.split(" ")) {
            nodes.offer(Integer.parseInt(s));
        }
        return build(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(Queue<Integer> nodes, int lower, int upper) {
        if (nodes.isEmpty()) return null;
        int val = nodes.peek();
        if (val < lower || val > upper) return null;

        nodes.poll();
        TreeNode root = new TreeNode(val);
        root.left = build(nodes, lower, val);
        root.right = build(nodes, val, upper);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized); // "2 1 3"

        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println("Deserialized Root: " + deserialized.val); // 2
        System.out.println("Left: " + deserialized.left.val); // 1
        System.out.println("Right: " + deserialized.right.val); // 3
    }
}

// Клас TreeNode як дано в умові
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

