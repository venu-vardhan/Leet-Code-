import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; ++i) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1; // Left pointer
            int k = n - 1; // Right pointer

            while (j < k) {
                int x = nums[i] + nums[j] + nums[k];

                if (x < 0) {
                    ++j; // Sum too small, move left pointer right
                } else if (x > 0) {
                    --k; // Sum too large, move right pointer left
                } else {
                    // Found a triplet that sums to zero
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    // Skip duplicates for the second and third elements
                    while (j < k && nums[j] == nums[j + 1]) {
                        ++j;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        --k;
                    }
                    
                    // Move both pointers inward to find other triplets
                    ++j;
                    --k;
                }
            }
        }
        return ans;
    }
}
