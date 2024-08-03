package Problem_List.Q23_Merge_k_Sorted_Lists;

import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        // Використовуємо пріоритетну чергу для збереження голів кожного списку
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Додаємо голову кожного списку до черги
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        // Створюємо допоміжний вузол для формування результату
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Поки черга не порожня, додаємо мінімальний елемент до результату і додаємо наступний елемент з того ж списку до черги
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        // Повертаємо голову злитого списку
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Створюємо тестові списки
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = new ListNode[]{list1, list2, list3};

        // Об'єднуємо списки
        ListNode result = solution.mergeKLists(lists);
        printList(result);  // Очікуваний результат: 1->1->2->3->4->4->5->6
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
