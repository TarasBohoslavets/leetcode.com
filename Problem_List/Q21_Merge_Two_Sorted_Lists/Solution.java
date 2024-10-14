package Problem_List.Q21_Merge_Two_Sorted_Lists;

class Solution {
//    public ListNode mergeTwoLists(ListNode list4, ListNode list2) {
//        // Create a dummy node
//        ListNode dummy = new ListNode(-1);
//        ListNode curr = dummy;
//
//        // Merge lists until one becomes empty
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                curr.next = list1;
//                list1 = list1.next;
//            } else {
//                curr.next = list2;
//                list2 = list2.next;
//            }
//            curr = curr.next;
//        }
//
//        // Connect remaining nodes of non-empty list
//        if (list1 != null) {
//            curr.next = list1;
//        } else {
//            curr.next = list2;
//        }
//
//        // Return the head of the merged list (next node of dummy)
//        return dummy.next;
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        // Example 1
//        ListNode list1_1 = new ListNode(1);
//        ListNode list1_2 = new ListNode(2);
//        ListNode list1_3 = new ListNode(4);
//        list1_1.next = list1_2;
//        list1_2.next = list1_3;
//
//        ListNode list2_1 = new ListNode(1);
//        ListNode list2_2 = new ListNode(3);
//        ListNode list2_3 = new ListNode(4);
//        list2_1.next = list2_2;
//        list2_2.next = list2_3;
//
//        System.out.println("Example 1:");
//        ListNode mergedList1 = solution.mergeTwoLists(list1_1, list2_1);
//        printList(mergedList1); // Output should be [1, 1, 2, 3, 4, 4]
//
//        // Example 2
//        System.out.println("\nExample 2:");
//        ListNode mergedList2 = solution.mergeTwoLists(null, null);
//        printList(mergedList2); // Output should be []
//
//        // Example 3
//        ListNode list3_1 = null;
//
//        ListNode list3_2 = new ListNode(0);
//
//        System.out.println("\nExample 3:");
//        ListNode mergedList3 = solution.mergeTwoLists(list3_1, list3_2);
//        printList(mergedList3); // Output should be [0]
//    }
//
//    // Helper method to print the linked list
//    private static void printList(ListNode head) {
//        ListNode current = head;
//        while (current != null) {
//            System.out.print(current.val + " ");
//            current = current.next;
//        }
//        System.out.println();
//    }
}

