import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // Result grid size is (m-k+1) x (n-k+1)
        int[][] ans = new int[m - k + 1][n - k + 1];

        // Slide over each possible top-left corner (i, j)
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                List<Integer> nums = new ArrayList<>();
                // Extract all elements in the current k x k submatrix
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        nums.add(grid[x][y]);
                    }
                }
                
                // Sort to find minimum absolute difference easily
                Collections.sort(nums);
                
                int minDiff = Integer.MAX_VALUE;
                boolean found = false;
                
                // Compare adjacent elements in sorted list
                for (int t = 1; t < nums.size(); t++) {
                    int a = nums.get(t - 1);
                    int b = nums.get(t);
                    if (a != b) {
                        minDiff = Math.min(minDiff, Math.abs(a - b));
                        found = true;
                    }
                }
                
                // If all elements are same, diff is 0, else minDiff
                ans[i][j] = found ? minDiff : 0;
            }
        }
        return ans;
    }
}
