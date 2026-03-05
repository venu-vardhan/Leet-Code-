import java.util.Arrays;

class Solution {
    /**
     * Finds three integers in the array whose sum is closest to the target.
     * @param nums The input integer array.
     * @param target The target integer.
     * @return The sum of the three integers closest to the target.
     */
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to use the two-pointer technique
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum with the first triplet
        int n = nums.length;

        // Iterate through each element to use as the first number in the triplet
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            // Use two pointers for the remaining elements
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If the current sum is exactly the target, return it immediately
                if (currentSum == target) {
                    return currentSum;
                }

                // Update the closest sum if the current sum is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers to try to get closer to the target
                if (currentSum < target) {
                    left++; // Need a larger sum, so increment the left pointer
                } else {
                    right--; // Need a smaller sum, so decrement the right pointer
                }
            }
        }
        return closestSum;
    }
}
