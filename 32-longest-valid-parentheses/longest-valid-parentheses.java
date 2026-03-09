import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        // Use a Deque as a stack to store indices
        Deque<Integer> stack = new ArrayDeque<>();
        // Push -1 to the stack as a base for the first potential valid substring
        stack.push(-1); 

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                // If it's '(', push its index onto the stack
                stack.push(i);
            } else {
                // If it's ')', pop the top element
                stack.pop(); 
                if (stack.isEmpty()) {
                    // If the stack is empty after popping, push the current index to mark the start of the next potential valid substring
                    stack.push(i);
                } else {
                    // Otherwise, calculate the length of the current valid substring
                    // which is the current index minus the index at the top of the stack
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
