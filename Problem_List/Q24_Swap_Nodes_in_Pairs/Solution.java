package Problem_List.Q24_Swap_Nodes_in_Pairs;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Створюємо допоміжний вузол, який буде перед head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Використовуємо current для проходження списку
        ListNode current = dummy;

        // Поки існують два вузли для обміну, міняємо їх місцями
        while (current.next != null && current.next.next != null) {
            // Визначаємо вузли, які потрібно поміняти місцями
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Міняємо місцями вузли
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Переміщуємо current на два вузли вперед
            current = first;
        }

        // Повертаємо голову оновленого списку
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Створюємо тестовий список [1, 2, 3, 4]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Переставляємо вузли парами
        ListNode newHead = solution.swapPairs(head);
        printList(newHead);  // Очікуваний результат: [2, 1, 4, 3]
    }

    // Метод для друку списку
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

