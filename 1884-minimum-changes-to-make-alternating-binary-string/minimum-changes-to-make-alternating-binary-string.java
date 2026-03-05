class Solution {
    public int minOperations(String s) {
        int cost10 = 0; // the cost to make s "1010..."

        // Iterate through the string, comparing each character to the expected character
        // if the pattern is "1010..." (where index % 2 determines the expected value)
        for (int i = 0; i < s.length(); i++) {
            // '0' in ASCII is 48, '1' is 49. Subtracting '0' converts '0' to 0 and '1' to 1.
            if (s.charAt(i) - '0' == i % 2) {
                cost10++;
            }
        }

        // The cost to make it "0101..." is the total length minus the cost for "1010..."
        final int cost01 = s.length() - cost10;

        // Return the minimum of the two costs
        return Math.min(cost10, cost01);
    }
}
