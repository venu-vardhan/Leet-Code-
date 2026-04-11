import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        // Map to store list of indices for each number
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        // Iterate through each number's list of indices
        for (List<Integer> indices : map.values()) {
            // A good tuple requires at least 3 occurrences
            if (indices.size() >= 3) {
                found = true;
                // Minimum distance for 3 indices i < j < k is 2 * (k - i)
                // We check adjacent triplets in the sorted index list
                for (int p = 0; p <= indices.size() - 3; p++) {
                    int i = indices.get(p);
                    int k = indices.get(p + 2);
                    int currentDist = 2 * (k - i);
                    minDistance = Math.min(minDistance, currentDist);
                }
            }
        }

        return found ? minDistance : -1;
    }
}
