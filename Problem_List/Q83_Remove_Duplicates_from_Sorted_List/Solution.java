package Problem_List.Q83_Remove_Duplicates_from_Sorted_List;

// Definition for singly-linked list.
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

        // Example 1
        ListNode head1 = new ListNode ( 1, new ListNode ( 1, new ListNode ( 2 ) ) );
        ListNode result1 = solution.deleteDuplicates ( head1 );
        printList ( result1 ); // Output should be [1, 2]

        // Example 2
        ListNode head2 = new ListNode ( 1, new ListNode ( 1, new ListNode ( 2, new ListNode ( 3, new ListNode ( 3 ) ) ) ) );
        ListNode result2 = solution.deleteDuplicates ( head2 );
        printList ( result2 ); // Output should be [1, 2, 3]
    }

    // Helper function to print the linked list
    public static void printList ( ListNode head ) {
        ListNode current = head;
        while (current != null) {
            System.out.print ( current.val );
            if ( current.next != null ) {
                System.out.print ( " -> " );
            }
            current = current.next;
        }
        System.out.println ( );
    }

    public ListNode deleteDuplicates ( ListNode head ) {
        // Initialize the current node as the head of the list
        ListNode current = head;

        // Traverse the list
        while (current != null && current.next != null) {
            // Compare the current node with the next node
            if ( current.val == current.next.val ) {
                // If they are the same, skip the next node
                current.next = current.next.next;
            } else {
                // Otherwise, move to the next node
                current = current.next;
            }
        }

        // Return the modified list
        return head;
    }
}

