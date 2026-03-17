public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0; // Invalid input: string is empty, null, or starts with '0'
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: one way to decode an empty string
        dp[1] = 1; // Base case: one way to decode a single non-zero digit

        for (int i = 2; i <= n; i++) {
            // Check if the single digit ending at the current position is valid
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Check if the two digits ending at the current position are valid
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
