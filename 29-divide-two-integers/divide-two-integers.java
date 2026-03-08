class Solution {
    public int divide(int dividend, int divisor) {
        // Handle the edge case for overflow: Integer.MIN_VALUE divided by -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Use long to avoid overflow when converting to absolute values
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        long result = 0;
        
        // The core logic uses bit shifting (doubling) to simulate division
        while (ldividend >= ldivisor) {
            long tempDivisor = ldivisor;
            long multiple = 1;
            // Find the largest multiple of ldivisor that is less than or equal to ldividend
            while (ldividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1; // Double the divisor
                multiple <<= 1;    // Double the multiple (which is a power of 2)
            }
            // Subtract the largest found multiple from the remaining dividend
            ldividend -= tempDivisor;
            // Add the corresponding power-of-two multiple to the result
            result += multiple;
        }

        // Apply the correct sign to the result
        result = isNegative ? -result : result;
        
        // Check for overflow against the 32-bit signed integer range
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) result;
    }
}
