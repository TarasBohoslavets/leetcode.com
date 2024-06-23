package Problem_List.Implement_Stack_using_Queues_225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> mainQueue;
    private Queue<Integer> auxQueue;

    public MyStack () {
        mainQueue = new LinkedList<> ( );
        auxQueue = new LinkedList<> ( );
    }

    public static void main ( String[] args ) {
        MyStack myStack = new MyStack ( );
        myStack.push ( 1 );
        myStack.push ( 2 );
        System.out.println ( myStack.top ( ) ); // Output: 2
        System.out.println ( myStack.pop ( ) ); // Output: 2
        System.out.println ( myStack.empty ( ) ); // Output: false
    }

    public void push ( int x ) {
        mainQueue.offer ( x );
    }

    public int pop () {
        while (mainQueue.size ( ) > 1) {
            auxQueue.offer ( mainQueue.poll ( ) );
        }
        int topElement = mainQueue.poll ( );
        Queue<Integer> temp = mainQueue;
        mainQueue = auxQueue;
        auxQueue = temp;
        return topElement;
    }

    public int top () {
        while (mainQueue.size ( ) > 1) {
            auxQueue.offer ( mainQueue.poll ( ) );
        }
        int topElement = mainQueue.poll ( );
        auxQueue.offer ( topElement );
        Queue<Integer> temp = mainQueue;
        mainQueue = auxQueue;
        auxQueue = temp;
        return topElement;
    }

    public boolean empty () {
        return mainQueue.isEmpty ( );
    }
}
