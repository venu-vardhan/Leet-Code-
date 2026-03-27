import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int samePoints = 1;
            int maxPoints = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    samePoints++;
                    continue;
                }

                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                String slope = dx + "#" + dy;
                map.put(slope, map.getOrDefault(slope, 0) + 1);

                maxPoints = Math.max(maxPoints, map.get(slope));
            }

            ans = Math.max(ans, maxPoints + samePoints);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}