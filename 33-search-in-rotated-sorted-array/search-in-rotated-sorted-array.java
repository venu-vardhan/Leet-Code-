class Solution {
    /**
     * Searches for a target value in a rotated sorted array.
     * @param nums The integer array, possibly rotated.
     * @param target The value to search for.
     * @return The index of the target if found, otherwise -1.
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids potential overflow

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target is within the sorted left half range
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left, so discard the right
                } else {
                    left = mid + 1; // Target is in the right half, so discard the left
                }
            } else { // The right half must be sorted
                // Check if target is within the sorted right half range
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right, so discard the left
                } else {
                    right = mid - 1; // Target is in the left half, so discard the right
                }
            }
        }

        return -1; // Target not found
    }
}
