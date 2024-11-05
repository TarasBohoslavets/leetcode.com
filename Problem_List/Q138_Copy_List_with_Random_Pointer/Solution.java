package Problem_List.Q138_Copy_List_with_Random_Pointer;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create new nodes and insert them after each original node
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Step 2: Assign random pointers to the new nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original list and the copied list
        current = head;
        Node copiedHead = head.next;
        Node copiedCurrent = copiedHead;
        while (current != null) {
            current.next = current.next.next;
            if (copiedCurrent.next != null) {
                copiedCurrent.next = copiedCurrent.next.next;
            }
            current = current.next;
            copiedCurrent = copiedCurrent.next;
        }

        return copiedHead;
    }
}

