package Problem_List.Q99_Recover_Binary_Search_Tree;

class Solution {
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode prevElement = null; // Замість Integer.MIN_VALUE

    public void recoverTree(TreeNode root) {
        // In-order обхід для пошуку неправильних вузлів
        traverse(root);

        // Обмінюємо значення між першим і другим переплутаними вузлами
        if (firstElement != null && secondElement != null) {
            int temp = firstElement.val;
            firstElement.val = secondElement.val;
            secondElement.val = temp;
        }
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // Обходимо ліве піддерево
        traverse(root.left);

        // Визначаємо перший і другий елементи
        if (prevElement != null && prevElement.val >= root.val) {
            if (firstElement == null) {
                firstElement = prevElement;
            }
            secondElement = root;
        }

        // Оновлюємо попередній елемент
        prevElement = root;

        // Обходимо праве піддерево
        traverse(root.right);
    }
}
