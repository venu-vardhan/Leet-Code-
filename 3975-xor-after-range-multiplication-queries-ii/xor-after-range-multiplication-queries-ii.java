import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = (int)Math.sqrt(n) + 1;

        // Sparse storage: k -> (remainder -> map(index -> multiplier))
        Map<Integer, Map<Integer, Map<Integer, Long>>> small = new HashMap<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            if (k >= B) {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int)((1L * nums[i] * v) % MOD);
                }
            } else {
                small.putIfAbsent(k, new HashMap<>());
                Map<Integer, Map<Integer, Long>> remMap = small.get(k);

                int rem = l % k;
                remMap.putIfAbsent(rem, new HashMap<>());
                Map<Integer, Long> map = remMap.get(rem);

                int start = (l - rem) / k;
                int end = (r - rem) / k;

                map.put(start, (map.getOrDefault(start, 1L) * v) % MOD);

                long inv = modInverse(v);
                map.put(end + 1, (map.getOrDefault(end + 1, 1L) * inv) % MOD);
            }
        }

        // Apply small k updates
        for (int k : small.keySet()) {
            Map<Integer, Map<Integer, Long>> remMap = small.get(k);

            for (int r : remMap.keySet()) {
                Map<Integer, Long> map = remMap.get(r);

                long mul = 1;
                int t = 0;

                while (true) {
                    if (map.containsKey(t)) {
                        mul = (mul * map.get(t)) % MOD;
                    }

                    int idx = r + t * k;
                    if (idx >= n) break;

                    nums[idx] = (int)((1L * nums[idx] * mul) % MOD);
                    t++;
                }
            }
        }

        int ans = 0;
        for (int x : nums) ans ^= x;

        return ans;
    }

    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}