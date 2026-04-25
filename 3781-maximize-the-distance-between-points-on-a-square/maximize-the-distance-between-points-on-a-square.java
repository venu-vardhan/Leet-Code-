import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        long[] unrolled = new long[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            if (y == 0) unrolled[i] = x;
            else if (x == side) unrolled[i] = (long) side + y;
            else if (y == side) unrolled[i] = (long) 2 * side + (side - x);
            else unrolled[i] = (long) 3 * side + (side - y);
        }
        Arrays.sort(unrolled);

        int low = 0, high = side, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(unrolled, k, mid, (long) 4 * side)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canPlace(long[] pts, int k, int dist, long totalLen) {
        int n = pts.length;
        // Optimization: Try starting from first few points only
        for (int start = 0; start < n; start++) {
            // Early exit if the remaining points can't possibly fit the circle
            if (pts[start] > pts[0] + dist) break; 
            
            int count = 1;
            long lastPos = pts[start];
            int curr = start;
            
            for (int i = 1; i < k; i++) {
                int nextIdx = lowerBound(pts, lastPos + dist);
                if (nextIdx >= n) {
                    count = 0; 
                    break;
                }
                lastPos = pts[nextIdx];
                count++;
            }
            
            // Check if the last point and the first point maintain the min distance
            if (count == k && (totalLen - (lastPos - pts[start])) >= dist) {
                return true;
            }
        }
        return false;
    }

    private int lowerBound(long[] pts, long target) {
        int l = 0, r = pts.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (pts[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
