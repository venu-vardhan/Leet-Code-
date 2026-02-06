import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        
        // Sort the array
        Arrays.sort(nums);
        
        int maxWindow = 1;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            // Shrink window until balanced
            while ((long) nums[right] > (long) nums[left] * k) {
                left++;
            }
            
            // Update maximum balanced window size
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        
        // Minimum removals
        return n - maxWindow;
    }
}
