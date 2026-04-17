import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        // Map to store the last seen index of a number's reverse
        Map<Integer, Integer> posMap = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            // Check if the current number nums[j] was previously 
            // expected as a reverse of some nums[i]
            if (posMap.containsKey(nums[j])) {
                minDistance = Math.min(minDistance, j - posMap.get(nums[j]));
            }
            
            // Store the reverse of the current number and its index
            // If multiple same values exist, updating to the latest index 
            // ensures the minimum distance for future matches
            posMap.put(reverse(nums[j]), j);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int reverse(int x) {
        int reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + (x % 10);
            x /= 10;
        }
        return reversed;
    }
}
