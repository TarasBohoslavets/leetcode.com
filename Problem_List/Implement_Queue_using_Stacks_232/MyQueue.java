package Problem_List.Implement_Queue_using_Stacks_232;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue () {
        stack1 = new Stack<> ( );
        stack2 = new Stack<> ( );
    }

    public static void main ( String[] args ) {
        MyQueue myQueue = new MyQueue ( );
        myQueue.push ( 1 ); // queue is: [1]
        myQueue.push ( 2 ); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println ( myQueue.peek ( ) ); // return 1
        System.out.println ( myQueue.pop ( ) ); // return 1, queue is [2]
        System.out.println ( myQueue.empty ( ) ); // return false
    }

    public void push ( int x ) {
        stack1.push ( x );
    }

    public int pop () {
        if ( stack2.isEmpty ( ) ) {
            while (!stack1.isEmpty ( )) {
                stack2.push ( stack1.pop ( ) );
            }
        }
        return stack2.pop ( );
    }

    public int peek () {
        if ( stack2.isEmpty ( ) ) {
            while (!stack1.isEmpty ( )) {
                stack2.push ( stack1.pop ( ) );
            }
        }
        return stack2.peek ( );
    }

    public boolean empty () {
        return stack1.isEmpty ( ) && stack2.isEmpty ( );
    }
}

