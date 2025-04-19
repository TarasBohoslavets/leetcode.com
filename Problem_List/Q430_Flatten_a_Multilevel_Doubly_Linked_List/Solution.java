package Problem_List.Q430_Flatten_a_Multilevel_Doubly_Linked_List;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        flattenDFS(head); // запускаємо глибоке сплющення
        return head;
    }

    // DFS-функція повертає останній вузол у сплющеному підсписку
    private Node flattenDFS(Node node) {
        Node current = node;
        Node last = null;

        while (current != null) {
            Node next = current.next;

            // Якщо є дочірній список
            if (current.child != null) {
                // Сплющуємо дочірній список
                Node childLast = flattenDFS(current.child);

                // Вставляємо child між current і next
                current.next = current.child;
                current.child.prev = current;

                // Якщо next не null — з’єднуємо childLast з next
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                // child вже не потрібен
                current.child = null;
                last = childLast;
            } else {
                last = current;
            }

            current = next;
        }

        return last;
    }
}

