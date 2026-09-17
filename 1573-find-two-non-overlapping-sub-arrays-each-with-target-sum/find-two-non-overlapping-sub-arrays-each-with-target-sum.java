import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // minLen[i] stores the minimum length of a valid subarray ending at or before index i
        int[] minLen = new int[n];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(minLen, INF);

        int left = 0;
        int currentSum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            // Shrink window from the left if sum exceeds target
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }

            // Carry forward the best length found so far
            if (right > 0) {
                minLen[right] = minLen[right - 1];
            }

            // Found a valid subarray with sum == target
            if (currentSum == target) {
                int curLen = right - left + 1;

                // Check if there is a non-overlapping valid subarray ending before 'left'
                if (left > 0 && minLen[left - 1] != INF) {
                    ans = Math.min(ans, curLen + minLen[left - 1]);
                }

                // Update the best subarray length ending at or before 'right'
                minLen[right] = Math.min(minLen[right], curLen);
            }
        }

        return ans >= INF ? -1 : ans;
    }
}