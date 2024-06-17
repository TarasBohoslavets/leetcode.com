package Problem_List.Remove_Linked_List_Elements_203;


class ListNode {
    int val;
    ListNode next;

    ListNode () {
    }

    ListNode ( int val ) {
        this.val = val;
    }

    ListNode ( int val, ListNode next ) {
        this.val = val;
        this.next = next;
    }
}


class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test case 1
        ListNode head1 = new ListNode ( 1 );
        head1.next = new ListNode ( 2 );
        head1.next.next = new ListNode ( 6 );
        head1.next.next.next = new ListNode ( 3 );
        head1.next.next.next.next = new ListNode ( 4 );
        head1.next.next.next.next.next = new ListNode ( 5 );
        head1.next.next.next.next.next.next = new ListNode ( 6 );
        ListNode result1 = solution.removeElements ( head1, 6 );
        printList ( result1 ); // Expected output: [1, 2, 3, 4, 5]

        // Test case 2
        ListNode head2 = null;
        ListNode result2 = solution.removeElements ( head2, 1 );
        printList ( result2 ); // Expected output: []

        // Test case 3
        ListNode head3 = new ListNode ( 7 );
        head3.next = new ListNode ( 7 );
        head3.next.next = new ListNode ( 7 );
        head3.next.next.next = new ListNode ( 7 );
        ListNode result3 = solution.removeElements ( head3, 7 );
        printList ( result3 ); // Expected output: []
    }

    private static void printList ( ListNode head ) {
        ListNode current = head;
        while (current != null) {
            System.out.print ( current.val + " " );
            current = current.next;
        }
        System.out.println ( );
    }

    public ListNode removeElements ( ListNode head, int val ) {
        // Create a dummy node that points to the head of the list
        ListNode dummy = new ListNode ( 0 );
        dummy.next = head;

        // Initialize current node and previous node pointers
        ListNode current = head;
        ListNode prev = dummy;

        // Iterate through the list
        while (current != null) {
            if ( current.val == val ) {
                // If current node needs to be removed, skip it
                prev.next = current.next;
            } else {
                // Otherwise, move prev pointer to the current node
                prev = current;
            }
            // Move current pointer to the next node
            current = current.next;
        }

        // Return the new head, which is next of dummy node
        return dummy.next;
    }
}
