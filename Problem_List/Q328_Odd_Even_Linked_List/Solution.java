package Problem_List.Q328_Odd_Even_Linked_List;


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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;          // Початковий непарний вузол (1-й)
        ListNode even = head.next;     // Початковий парний вузол (2-й)
        ListNode evenHead = even;      // Запам’ятовуємо голову парної групи

        while (even != null && even.next != null) {
            odd.next = even.next;      // Пропускаємо один вузол вперед (непарний)
            odd = odd.next;            // Переміщаємо `odd` в наступний непарний вузол
            even.next = odd.next;      // Пропускаємо один вузол вперед (парний)
            even = even.next;          // Переміщаємо `even` в наступний парний вузол
        }

        odd.next = evenHead;           // Приєднуємо парну групу після непарної
        return head;
    }

    // Метод для друку списку (зручно для тестування)
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Приклад тестування
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Створюємо вхідний список: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Input: ");
        printList(head);

        ListNode result = sol.oddEvenList(head);

        System.out.print("Output: ");
        printList(result); // Очікуваний вихід: 1 -> 3 -> 5 -> 2 -> 4 -> null
    }
}

