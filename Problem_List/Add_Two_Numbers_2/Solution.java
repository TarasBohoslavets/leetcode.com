package Problem_List.Add_Two_Numbers_2;

// Визначення класу ListNode
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

class AddTwoNumbers {
    public static void main ( String[] args ) {
        // Створення прикладів зв'язаних списків
        ListNode l1 = new ListNode ( 2 );
        l1.next = new ListNode ( 4 );
        l1.next.next = new ListNode ( 3 );

        ListNode l2 = new ListNode ( 5 );
        l2.next = new ListNode ( 6 );
        l2.next.next = new ListNode ( 4 );

        AddTwoNumbers solution = new AddTwoNumbers ( );
        ListNode result = solution.addTwoNumbers ( l1, l2 );

        // Виведення результату
        while (result != null) {
            System.out.print ( result.val );
            if ( result.next != null ) {
                System.out.print ( " -> " );
            }
            result = result.next;
        }
        // Вихід: 7 -> 0 -> 8
    }

    public ListNode addTwoNumbers ( ListNode l1, ListNode l2 ) {
        // Створюємо головний вузол результату
        ListNode dummyHead = new ListNode ( 0 );
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0; // Змінна для зберігання перенесення
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y; // Обчислюємо суму з урахуванням перенесення
            carry = sum / 10; // Оновлюємо перенесення
            curr.next = new ListNode ( sum % 10 ); // Додаємо новий вузол з залишком від ділення на 10
            curr = curr.next; // Переходимо до наступного вузла
            if ( p != null ) p = p.next;
            if ( q != null ) q = q.next;
        }
        if ( carry > 0 ) {
            curr.next = new ListNode ( carry ); // Якщо залишилося перенесення, додаємо його до результату
        }
        return dummyHead.next; // Повертаємо результат без головного вузла
    }
}
