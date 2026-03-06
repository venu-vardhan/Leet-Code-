import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        // Sort the potions array to use binary search
        Arrays.sort(potions);
        int[] pairs = new int[n];

        for (int i = 0; i < n; i++) {
            long spellStrength = spells[i];
            // Calculate the minimum required potion strength (handle potential overflow)
            long minPotionNeeded = (long) Math.ceil((double) success / spellStrength);

            // Use binary search (or a custom lower_bound function) to find the index of the first valid potion
            int left = 0;
            int right = m - 1;
            int firstValidIndex = m; // Initialize to m, meaning no potion is strong enough

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] >= minPotionNeeded) {
                    firstValidIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            // The number of successful pairs is the number of elements from the first valid index to the end
            pairs[i] = m - firstValidIndex;
        }

        return pairs;
    }
}
