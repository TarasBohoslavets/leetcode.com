package Problem_List.Q382_Linked_List_Random_Node;

import java.util.Random;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int result = head.val;
        ListNode current = head;
        int index = 1;

        while (current.next != null) {
            current = current.next;
            if (random.nextInt(++index) == 0) {
                result = current.val;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Створюємо список: 1 -> 2 -> 3
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        // Ініціалізація об'єкта Solution
        Solution solution = new Solution(head);

        // Виклики getRandom() (повертає випадкові значення 1, 2 або 3)
        System.out.println(solution.getRandom()); // може бути 1, 2 або 3
        System.out.println(solution.getRandom()); // може бути 1, 2 або 3
        System.out.println(solution.getRandom()); // може бути 1, 2 або 3
        System.out.println(solution.getRandom()); // може бути 1, 2 або 3
        System.out.println(solution.getRandom()); // може бути 1, 2 або 3
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */