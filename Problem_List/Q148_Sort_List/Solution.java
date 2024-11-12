package Problem_List.Q148_Sort_List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode sortList(ListNode head) {
        // Якщо список порожній або містить один елемент, то він уже відсортований
        if (head == null || head.next == null) return head;

        // Розділяємо список на дві частини
        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        // Рекурсивно сортуємо ліву і праву частини
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // З'єднуємо відсортовані частини
        return merge(left, right);
    }

    // Допоміжна функція для пошуку середини списку
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Функція для злиття двох відсортованих списків
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Додаємо залишки
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}
