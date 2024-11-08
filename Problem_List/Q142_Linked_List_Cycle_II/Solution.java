package Problem_List.Q142_Linked_List_Cycle_II;

class ListNode {
    int val;       // значення вузла
    ListNode next; // вказівник на наступний вузол

    ListNode(int x) {
        val = x;   // ініціалізація значення вузла
        next = null; // ініціалізація наступного вузла як null
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Крок 1: Виявлення циклу за допомогою повільного та швидкого вказівників
        while (fast != null && fast.next != null) {
            slow = slow.next;         // рухається на 1 крок
            fast = fast.next.next;    // рухається на 2 кроки

            // Якщо `slow` і `fast` зустрілися, це означає, що цикл існує
            if (slow == fast) {
                // Крок 2: Пошук початку циклу
                ListNode entry = head;

                // Починаємо рухати `entry` і `slow` на один крок
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry; // Початок циклу
            }
        }

        return null; // Якщо циклу немає
    }
}
