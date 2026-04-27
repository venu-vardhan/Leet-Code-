class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length(), len2 = s2.length();
        // countr[i] stores the total s2 count after processing (i+1) s1 blocks
        int[] countr = new int[n1 + 1];
        // indexr[i] stores the current index in s2 after processing (i+1) s1 blocks
        int[] indexr = new int[n1 + 1];
        int count = 0, index = 0;

        for (int i = 1; i <= n1; i++) {
            // Process one full s1 block
            for (int j = 0; j < len1; j++) {
                if (s1.charAt(j) == s2.charAt(index)) {
                    index++;
                    if (index == len2) {
                        index = 0;
                        count++;
                    }
                }
            }
            countr[i] = count;
            indexr[i] = index;

            // Check if we have seen this index in s2 before (detect cycle)
            for (int k = 0; k < i; k++) {
                if (indexr[k] == index) {
                    // Pattern found between block k and block i
                    int prev_count = countr[k];
                    int pattern_count = (countr[i] - countr[k]) * ((n1 - k) / (i - k));
                    int remain_count = countr[k + (n1 - k) % (i - k)] - countr[k];
                    return (prev_count + pattern_count + remain_count) / n2;
                }
            }
        }
        return countr[n1] / n2;
    }
}
