class Solution {
    public int reverse(int x) {
        long rev = 0; // Use long to handle potential overflow during reversal
        while (x != 0) {
            // Extract the last digit of x
            int pop = x % 10;
            // Shift the reversed number one decimal place to the left and add the new digit
            rev = rev * 10 + pop;
            // Remove the last digit from x
            x /= 10;
        }
        
        // Check if the reversed number is outside the 32-bit signed integer range
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        
        // Cast the valid result back to an int
        return (int) rev;
    }
}
