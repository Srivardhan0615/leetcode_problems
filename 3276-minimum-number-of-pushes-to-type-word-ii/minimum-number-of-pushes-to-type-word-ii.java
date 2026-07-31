class Solution {
    public int minimumPushes(String word) {

        int[] freq = new int[26];

        // Count frequencies
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Sort in ascending order
        Arrays.sort(freq);

        int ans = 0;
        int push = 1;
        int count = 0;

        // Traverse from largest frequency
        for (int i = 25; i >= 0; i--) {

            if (freq[i] == 0) break;

            ans += freq[i] * push;
            count++;

            if (count == 8) {
                push++;
                count = 0;
            }
        }

        return ans;
    }
}