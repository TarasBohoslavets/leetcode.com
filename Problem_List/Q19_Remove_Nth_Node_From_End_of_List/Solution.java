package Problem_List.Q19_Remove_Nth_Node_From_End_of_List;

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

public class Solution {
    private ListNode removeNthFromEnd(ListNode head, int n) {
        // Створюємо допоміжний вузол, який буде перед head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Два вказівники, які починаються з допоміжного вузла
        ListNode first = dummy;
        ListNode second = dummy;

        // Рухаємо first на n+1 кроків вперед
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Рухаємо first до кінця списку, рухаючи second разом з ним
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Тепер second.next - це вузол, який потрібно видалити
        second.next = second.next.next;

        // Повертаємо голову оновленого списку
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Створюємо тестовий список [1, 2, 3, 4, 5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Видаляємо 2-й вузол з кінця
        ListNode newHead = solution.removeNthFromEnd(head, 2);
        printList(newHead);  // Очікуваний результат: [1, 2, 3, 5]
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
