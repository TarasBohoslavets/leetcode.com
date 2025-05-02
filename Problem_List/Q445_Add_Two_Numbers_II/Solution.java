package Problem_List.Q445_Add_Two_Numbers_II;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Заповнюємо стеки значеннями з l1 та l2
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode result = null;

        // Поки є цифри або залишився перенос
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();

            // створюємо новий вузол на початку
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = result;
            result = newNode;

            carry = sum / 10;
        }

        return result;
    }
}

