package Problem_List.Q82_Remove_Duplicates_from_Sorted_List_II;

// Визначення вузла для однозв'язного списку
class ListNode {
    int val;
    ListNode next;

    // Конструктор за замовчуванням
    ListNode() {}

    // Конструктор з одним параметром
    ListNode(int val) {
        this.val = val;
    }

    // Конструктор з двома параметрами
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Основне рішення для видалення дублікатів
public class Solution {
    private ListNode deleteDuplicates(ListNode head) {
        // Створюємо фіктивний вузол для спрощення обробки початкових дублікатів
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Вказівник на попередній вузол
        ListNode prev = dummy;

        while (head != null) {
            // Якщо поточний елемент і наступний мають однакові значення
            if (head.next != null && head.val == head.next.val) {
                // Пропускаємо всі вузли з однаковими значеннями
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Зв'язуємо попередній вузол з наступним неповторюваним елементом
                prev.next = head.next;
            } else {
                // Якщо немає дублікатів, пересуваємо prev
                prev = prev.next;
            }
            // Переміщуємося до наступного вузла
            head = head.next;
        }

        // Повертаємо новий список після фіктивного вузла
        return dummy.next;
    }

    // Тестування методу
    public static void main(String[] args) {
        // Створення тестового списку [1,2,3,3,4,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        // Виклик методу для видалення дублікатів
        Solution sol = new Solution();
        ListNode result = sol.deleteDuplicates(head);

        // Виведення результату
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Очікуваний результат: 1 2 5
    }
}
