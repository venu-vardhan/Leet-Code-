class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007; // The modulo value (10^9 + 7)
        long ans = 0; // Use a long to prevent overflow during calculations
        int shift = 0; // Tracks the number of bits to shift

        for (int i = 1; i <= n; ++i) {
            // Check if 'i' is a power of 2, indicating the number of bits increases for subsequent numbers
            if ((i & (i - 1)) == 0) {
                ++shift;
            }
            // Shift the current 'ans' left by 'shift' bits and then OR with 'i'
            ans = ((ans << shift) | i) % MOD;
        }
        return (int) ans;
    }
}
