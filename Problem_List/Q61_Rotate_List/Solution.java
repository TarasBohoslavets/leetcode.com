package Problem_List.Q61_Rotate_List;


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
    public ListNode rotateRight(ListNode head, int k) {
        // Якщо список порожній або має один елемент, повертаємо його як є
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Обчислюємо довжину списку та знаходимо останній елемент
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        // Обчислюємо реальне значення k (беремо залишок від ділення на довжину списку)
        k = k % length;
        if (k == 0) {
            return head;  // Якщо k кратне довжині списку, список залишається тим самим
        }

        // Зв'язуємо кінець списку з його початком, створюючи цикл
        last.next = head;

        // Знайдемо новий кінець списку: це (length - k - 1)-й елемент
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // Новий початок - наступний елемент після нового кінця
        ListNode newHead = newTail.next;

        // Розриваємо цикл
        newTail.next = null;

        return newHead;
    }
}
