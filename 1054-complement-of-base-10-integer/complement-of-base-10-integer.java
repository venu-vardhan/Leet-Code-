class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        int mask = 1;
        // Create a mask of all 1s that covers all bits of n
        while (mask < n) {
            mask = (mask << 1) | 1; // Equivalent to mask = mask * 2 + 1
        }
        
        // XOR n with the mask to flip the necessary bits
        return mask ^ n;
    }
}
