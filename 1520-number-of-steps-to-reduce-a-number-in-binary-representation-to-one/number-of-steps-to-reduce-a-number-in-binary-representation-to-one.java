class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        // Iterate from the second-last character to the beginning
        for (int i = s.length() - 1; i > 0; i--) {
            steps++;
            // Check if the current bit + carry is odd
            if ((s.charAt(i) - '0') + carry == 1) {
                // Number is odd, need to add 1, which incurs 2 steps (add 1, then divide by 2)
                carry = 1;
                steps++; // This effectively accounts for the division by 2 in the next step
            }
            // If the current bit + carry is even (0 or 2), the division by 2 is handled by the loop iteration
        }
        // If there's a carry left after processing all bits, it means we had to add 1 to the most significant bit (the '1' at the start),
        // which then resulted in a '10' (binary), and the '1' is the final '1', the '0' was divided out.
        // So we add one final step for the remaining carry.
        return steps + carry;
    }
}
