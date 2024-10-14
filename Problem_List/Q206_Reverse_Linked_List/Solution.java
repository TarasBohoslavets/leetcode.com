package Problem_List.Q206_Reverse_Linked_List;


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

        // Create a linked list 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode ( 1 );
        head.next = new ListNode ( 2 );
        head.next.next = new ListNode ( 3 );
        head.next.next.next = new ListNode ( 4 );
        head.next.next.next.next = new ListNode ( 5 );

        // Reverse the linked list
        ListNode reversedHead = solution.reverseList ( head );

        // Print the reversed linked list
        ListNode current = reversedHead;
        while (current != null) {
            System.out.print ( current.val + " " );
            current = current.next;
        }
        // Expected output: 5 4 3 2 1
    }

    public ListNode reverseList ( ListNode head ) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next; // Save the next node
            current.next = prev;          // Reverse the current node's pointer
            prev = current;               // Move prev to this node
            current = next;               // Move to the next node
        }

        return prev; // prev will be the new head at the end
    }
}

