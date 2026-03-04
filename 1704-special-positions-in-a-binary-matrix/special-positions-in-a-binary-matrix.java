class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];

        // First pass: Count the number of ones in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowOnes[i]++;
                    colOnes[j]++;
                }
            }
        }

        int specialPositionsCount = 0;

        // Second pass: Check for special positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // A position is special if mat[i][j] is 1 AND its row and column only have one '1'
                if (mat[i][j] == 1 && rowOnes[i] == 1 && colOnes[j] == 1) {
                    specialPositionsCount++;
                }
            }
        }

        return specialPositionsCount;
    }
}
