package Problem_List.Palindrome_Linked_List_234;

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

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        ListNode node4 = new ListNode ( 1 );
        ListNode node3 = new ListNode ( 2, node4 );
        ListNode node2 = new ListNode ( 2, node3 );
        ListNode node1 = new ListNode ( 1, node2 );
        System.out.println ( solution.isPalindrome ( node1 ) ); // true

        ListNode node6 = new ListNode ( 2 );
        ListNode node5 = new ListNode ( 1, node6 );
        System.out.println ( solution.isPalindrome ( node5 ) ); // false
    }

    public boolean isPalindrome ( ListNode head ) {
        if ( head == null || head.next == null ) {
            return true;
        }

        // Step 1: Find the middle of the linked list using the fast and slow pointers.
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list.
        ListNode secondHalfHead = reverseList ( slow );
        ListNode firstHalfHead = head;

        // Step 3: Compare the first half with the reversed second half.
        while (secondHalfHead != null) {
            if ( firstHalfHead.val != secondHalfHead.val ) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }

        // Optional: Restore the original list by reversing the second half back.
        // reverseList(slow);

        return true;
    }

    private ListNode reverseList ( ListNode head ) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}

