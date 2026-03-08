class Solution {
    public int removeElement(int[] nums, int val) {
        // 'k' is the keeper pointer, tracking the position for the next valid element.
        int k = 0;

        // 'i' is the explorer pointer, iterating through all elements.
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not equal to val, it's a "keeper".
            if (nums[i] != val) {
                // Place the keeper element at the current 'k' position.
                nums[k] = nums[i];
                // Increment 'k' to prepare for the next keeper.
                k++;
            }
            // If nums[i] == val, we simply skip it. 'k' remains unchanged,
            // effectively "removing" the element from the valid part of the array.
        }

        // 'k' now holds the count of elements not equal to val.
        return k;
    }
}
