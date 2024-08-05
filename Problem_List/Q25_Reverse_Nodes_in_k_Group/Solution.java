package Problem_List.Q25_Reverse_Nodes_in_k_Group;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    private ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode newHead = null;
        ListNode kTail = null;

        while (curr != null) {
            int count = 0;
            curr = head;
            while (count < k && curr != null) {
                curr = curr.next;
                count++;
            }

            if (count == k) {
                ListNode reversedSection = reverse(head, k);
                if (newHead == null) {
                    newHead = reversedSection;
                }
                if (kTail != null) {
                    kTail.next = reversedSection;
                }
                kTail = head;
                head = curr;
            } else {
                if (kTail != null) {
                    kTail.next = head;
                }
            }
        }

        return newHead == null ? head : newHead;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        while (k > 0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            k--;
        }

        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Створюємо тестовий список [1, 2, 3, 4, 5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Реверсуємо вузли по групах з 2 елементів
        ListNode newHead = solution.reverseKGroup(head, 2);
        printList(newHead);  // Очікуваний результат: [2, 1, 4, 3, 5]

        // Реверсуємо вузли по групах з 3 елементів
        newHead = solution.reverseKGroup(head, 3);
        printList(newHead);  // Очікуваний результат: [3, 2, 1, 4, 5]
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

