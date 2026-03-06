import java.util.Arrays;

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int maxEnergy = Integer.MIN_VALUE;

        // Iterate backward from the last possible starting indices
        for (int i = n - 1; i >= 0; --i) {
            // If we can make a jump of 'k' steps, add the downstream energy
            if (i + k < n) {
                energy[i] += energy[i + k];
            }
            // Update the maximum energy found so far
            if (energy[i] > maxEnergy) {
                maxEnergy = energy[i];
            }
        }
        return maxEnergy;
    }
}
