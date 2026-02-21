class Solution {
    public int countPrimeSetBits(int left, int right) {
        // Pre-computed bitmask for primes 2, 3, 5, 7, 11, 13, 17, 19
        // 1 << 2 | 1 << 3 | 1 << 5 | 1 << 7 | 1 << 11 | 1 << 13 | 1 << 17 | 1 << 19
        final int primeBits = 665772; 
        int ans = 0;
        
        for (int num = left; num <= right; ++num) {
            // Get the count of set bits using the built-in Java function
            int setBits = Integer.bitCount(num); 
            
            // Check if the setBits-th bit in the primeBits mask is set (i.e., if it's prime)
            if ((primeBits >> setBits & 1) == 1) {
                ans++;
            }
        }
        
        return ans;
    }
}
