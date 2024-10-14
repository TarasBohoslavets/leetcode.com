package Problem_List.Q141_Linked_List_Cycle;

class ListNode {
    int val;
    ListNode next;

    ListNode ( int x ) {
        val = x;
        next = null;
    }
}

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Приклад 1
        ListNode node1 = new ListNode ( 3 );
        ListNode node2 = new ListNode ( 2 );
        ListNode node3 = new ListNode ( 0 );
        ListNode node4 = new ListNode ( -4 );
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // цикл назад до node2
        System.out.println ( solution.hasCycle ( node1 ) ); // Вивід: true

        // Приклад 2
        ListNode node5 = new ListNode ( 1 );
        ListNode node6 = new ListNode ( 2 );
        node5.next = node6;
        node6.next = node5; // цикл назад до node5
        System.out.println ( solution.hasCycle ( node5 ) ); // Вивід: true

        // Приклад 3
        ListNode node7 = new ListNode ( 1 );
        System.out.println ( solution.hasCycle ( node7 ) ); // Вивід: false
    }

    public boolean hasCycle ( ListNode head ) {
        if ( head == null || head.next == null ) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if ( fast == null || fast.next == null ) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
