package Problem_List.Q160_Intersection_of_Two_Linked_Lists;


 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        // Traverse through the lists
        while (pA != pB) {
            // If pA reaches the end of list A, move it to the head of list B
            pA = (pA == null) ? headB : pA.next;

            // If pB reaches the end of list B, move it to the head of list A
            pB = (pB == null) ? headA : pB.next;
        }

        // Either pA == pB (intersection) or both are null (no intersection)
        return pA;
    }
}

