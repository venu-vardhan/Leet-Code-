class Solution {
    public String findDifferentBinaryString(String[] nums) {
        // The length of the input array 'n' is also the length of each binary string.
        int n = nums.length;
        // Use a StringBuilder for efficient string concatenation.
        StringBuilder ans = new StringBuilder();

        // Iterate through each string, looking at the character at the diagonal index.
        for (int i = 0; i < n; i++) {
            // Get the character at the current diagonal position.
            char currentChar = nums[i].charAt(i);
            // Flip the bit: if '0', append '1'; if '1', append '0'.
            if (currentChar == '0') {
                ans.append('1');
            } else {
                ans.append('0');
            }
        }
        
        // Convert the StringBuilder to a String and return.
        return ans.toString();
    }
}
