package Problem_List.Q147_Insertion_Sort_List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0); // Початковий вузол для відсортованого списку
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy; // Починаємо завжди з початку відсортованого списку
            ListNode next = curr.next; // Зберігаємо наступний вузол

            // Знаходимо місце для вставки
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Вставляємо вузол в правильну позицію
            curr.next = prev.next;
            prev.next = curr;

            // Переходимо до наступного вузла у початковому списку
            curr = next;
        }

        return dummy.next;
    }
}

