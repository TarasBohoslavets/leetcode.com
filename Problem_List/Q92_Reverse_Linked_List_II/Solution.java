package Problem_List.Q92_Reverse_Linked_List_II;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // 1. Дійти до позиції перед `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 2. Початок реверсу
        ListNode start = prev.next;
        ListNode then = start.next;

        // 3. Виконання реверсу між позиціями `left` і `right`
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        ListNode head1 = createLinkedList(new int[] {1, 2, 3, 4, 5});
        int left1 = 2, right1 = 4;
        ListNode result1 = solution.reverseBetween(head1, left1, right1);
        System.out.print("Приклад 1 - Вихід: ");
        printLinkedList(result1);  // Очікуваний вихід: [1, 4, 3, 2, 5]

        // Приклад 2
        ListNode head2 = createLinkedList(new int[] {5});
        int left2 = 1, right2 = 1;
        ListNode result2 = solution.reverseBetween(head2, left2, right2);
        System.out.print("Приклад 2 - Вихід: ");
        printLinkedList(result2);  // Очікуваний вихід: [5]
    }

    // Допоміжний метод для створення однозв'язного списку з масиву
    private static ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Допоміжний метод для виведення однозв'язного списку
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : "\n"));
            current = current.next;
        }
    }
}

// Опис класу вузла для однозв'язного списку
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

