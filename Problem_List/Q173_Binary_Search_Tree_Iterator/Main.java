package Problem_List.Q173_Binary_Search_Tree_Iterator;

import java.util.Stack;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    // Returns the next smallest number
    public int next() {
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }

    // Returns whether we have a next smallest number
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Helper method to push all left nodes into the stack
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        // Create tree: [7, 3, 15, null, null, 9, 20]
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);

        System.out.println(iterator.next());    // Output: 3
        System.out.println(iterator.next());    // Output: 7
        System.out.println(iterator.hasNext()); // Output: true
        System.out.println(iterator.next());    // Output: 9
        System.out.println(iterator.hasNext()); // Output: true
        System.out.println(iterator.next());    // Output: 15
        System.out.println(iterator.hasNext()); // Output: true
        System.out.println(iterator.next());    // Output: 20
        System.out.println(iterator.hasNext()); // Output: false
    }
}

