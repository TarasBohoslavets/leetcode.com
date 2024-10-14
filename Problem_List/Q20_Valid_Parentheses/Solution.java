package Problem_List.Q20_Valid_Parentheses;

import java.util.Stack;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        String input1 = "()";
        System.out.println ( "Example 1:" );
        System.out.println ( "Input: " + input1 );
        System.out.println ( "Output: " + solution.isValid ( input1 ) ); // Output should be true

        // Example 2
        String input2 = "()[]{}";
        System.out.println ( "\nExample 2:" );
        System.out.println ( "Input: " + input2 );
        System.out.println ( "Output: " + solution.isValid ( input2 ) ); // Output should be true

        // Example 3
        String input3 = "(]";
        System.out.println ( "\nExample 3:" );
        System.out.println ( "Input: " + input3 );
        System.out.println ( "Output: " + solution.isValid ( input3 ) ); // Output should be false
    }

    public boolean isValid ( String s ) {
        // Initialize an empty stack
        Stack<Character> stack = new Stack<> ( );

        // Iterate through each character in the string
        for (char c : s.toCharArray ( )) {
            // If the current character is an opening bracket, push it onto the stack
            if ( c == '(' || c == '[' || c == '{' ) {
                stack.push ( c );
            }
            // If the current character is a closing bracket
            else {
                // If the stack is empty, there's no matching opening bracket, return false
                if ( stack.isEmpty ( ) ) {
                    return false;
                }
                // Pop the top element from the stack
                char top = stack.pop ( );
                // Check if the popped opening bracket matches the current closing bracket
                if ( (c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{') ) {
                    return false;
                }
            }
        }

        // If the stack is not empty, there are unmatched opening brackets, return false
        return stack.isEmpty ( );
    }
}

