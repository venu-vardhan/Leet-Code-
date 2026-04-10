import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        // Map to store the indices where each number appears
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;
        
        for (List<Integer> indices : map.values()) {
            // A good tuple requires at least three occurrences of the same number
            if (indices.size() >= 3) {
                found = true;
                // Sliding window: check every consecutive triplet of indices
                for (int i = 0; i <= indices.size() - 3; i++) {
                    int first = indices.get(i);
                    int third = indices.get(i + 2);
                    // Distance formula simplifies to 2 * (max_index - min_index)
                    int currentDistance = 2 * (third - first);
                    minDistance = Math.min(minDistance, currentDistance);
                }
            }
        }
        
        return found ? minDistance : -1;
    }
}
