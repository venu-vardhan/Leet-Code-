class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        // The problem uses 10^9 + 7 as the modulus for updates
        final int MOD = 1_000_000_007;

        // Step 1: Process each query sequentially
        for (int[] query : queries) {
            int l = query[0]; // Start index
            int r = query[1]; // End index
            int k = query[2]; // Jump size
            int v = query[3]; // Multiplier

            // Update every k-th element in the range [l, r]
            for (int idx = l; idx <= r; idx += k) {
                // Use 1L to promote to long and prevent overflow before modulo
                nums[idx] = (int) ((1L * nums[idx] * v) % MOD);
            }
        }

        // Step 2: Compute the bitwise XOR of all elements in the final array
        int resultXor = 0;
        for (int num : nums) {
            resultXor ^= num;
        }

        return resultXor;
    }
}
