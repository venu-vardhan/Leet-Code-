public class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length, ans = 0;
        int[] suffixZeros = new int[n];
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; --j) count++;
            suffixZeros[i] = count;
        }
        for (int i = 0; i < n; ++i) {
            int needed = n - 1 - i, j = i;
            while (j < n && suffixZeros[j] < needed) j++;
            if (j == n) return -1;
            ans += (j - i);
            while (j > i) {
                int tmp = suffixZeros[j];
                suffixZeros[j] = suffixZeros[j-1];
                suffixZeros[j-1] = tmp;
                j--;
            }
        }
        return ans;
    }
}
