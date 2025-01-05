package Problem_List.Q237_Delete_Node_in_a_Linked_List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public void deleteNode(ListNode node) {
        // Скопіюємо значення наступного вузла до поточного вузла
        node.val = node.next.val;
        // Перенаправимо вказівник `next` на вузол після наступного
        node.next = node.next.next;
    }
}

