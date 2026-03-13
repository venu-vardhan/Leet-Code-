import java.util.*;

class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        // A sufficiently large upper bound for time can be estimated,
        // for example, max(workerTimes) * mountainHeight * mountainHeight (rough upper bound)
        // or a more precise one. 10^16 is a safe bet for the constraints.
        long right = 10000000000000000L; 

        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isPossible(mountainHeight, workerTimes, mid)) {
                ans = mid;
                right = mid - 1; // Try for a smaller time
            } else {
                left = mid + 1; // Need more time
            }
        }

        return ans;
    }

    private boolean isPossible(int mountainHeight, int[] workerTimes, long T) {
        long totalReducedHeight = 0;
        for (int workerTime : workerTimes) {
            // Calculate max height 'h' this worker can reduce within time T
            // The equation is workerTime * h * (h + 1) / 2 <= T
            // Which simplifies to h^2 + h - 2*T/workerTime <= 0
            // Using the quadratic formula to find the positive root bound
            // h <= (-1 + sqrt(1 + 8*T/workerTime)) / 2
            
            // Be careful with large numbers, cast T to long for calculation
            long val = 8L * T / workerTime + 1;
            long h = (long) ((Math.sqrt(val) - 1) / 2);
            totalReducedHeight += h;
            
            // Optimization: If we already surpassed the required height, return true early
            if (totalReducedHeight >= mountainHeight) {
                return true;
            }
        }
        return totalReducedHeight >= mountainHeight;
    }
}
