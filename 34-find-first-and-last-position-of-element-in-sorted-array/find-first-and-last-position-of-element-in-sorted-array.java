class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = firstGreaterEqual(nums, target);
        if (l == nums.length || nums[l] != target) {
            return new int[] {-1, -1};
        }
        int r = firstGreaterEqual(nums, target + 1) - 1;
        return new int[] {l, r};
    }

    private int firstGreaterEqual(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
