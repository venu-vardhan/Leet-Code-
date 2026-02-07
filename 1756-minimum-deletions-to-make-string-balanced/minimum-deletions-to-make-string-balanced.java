class Solution {
    public int minimumDeletions(String s) {
        int countB = 0;
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                countB++;
            } else { // c == 'a'
                // Either delete this 'a' or delete all previous 'b's
                deletions = Math.min(deletions + 1, countB);
            }
        }

        return deletions;
    }
}
