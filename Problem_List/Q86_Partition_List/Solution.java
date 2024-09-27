package Problem_List.Q86_Partition_List;

class Solution {
    private static class ListNode {
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
    public ListNode partition(ListNode head, int x) {
        // Створюємо два тимчасових вузли, які будуть використовуватися для двох списків:
        // beforeHead - для вузлів, значення яких менше за x
        // afterHead - для вузлів, значення яких більше або рівні x
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead; // Вказівник на поточну позицію в списку "before"
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead; // Вказівник на поточну позицію в списку "after"

        // Проходимо через весь початковий список
        while (head != null) {
            // Якщо значення поточного вузла менше за x
            if (head.val < x) {
                before.next = head; // Додаємо цей вузол до списку "before"
                before = before.next; // Переміщаємо вказівник вперед
            } else {
                // Якщо значення вузла більше або рівне x, додаємо його до списку "after"
                after.next = head;
                after = after.next;
            }
            head = head.next; // Переходимо до наступного вузла у вихідному списку
        }
        // Закриваємо список "after", щоб уникнути циклів
        after.next = null;

        // З'єднуємо кінець списку "before" зі списком "after"
        before.next = afterHead.next;

        // Повертаємо об'єднаний список, починаючи з голови списку "before"
        return beforeHead.next;
    }
}

