import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use an array of HashSets to track occurrences for each row, column, and subgrid
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];

                if (currentVal == '.') {
                    continue; // Skip empty cells
                }

                // Check row
                if (!rows[i].add(currentVal)) {
                    return false;
                }

                // Check column
                if (!columns[j].add(currentVal)) {
                    return false;
                }

                // Check 3x3 box
                // Formula to calculate the box index: (i/3) * 3 + (j/3)
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (!boxes[boxIndex].add(currentVal)) {
                    return false;
                }
            }
        }

        return true;
    }
}
