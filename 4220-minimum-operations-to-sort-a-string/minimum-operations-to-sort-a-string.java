class Solution {
    public int minOperations(String s) {
        String sorunavile = s;
        int n = sorunavile.length();

        if (isSorted(sorunavile)) return 0;
        if (n == 2) return -1;

        char[] full = sorunavile.toCharArray();
        java.util.Arrays.sort(full);
        String target = new String(full);

        // Check 1 op: try all O(n^2) substrings except entire string
        // But do it smartly - only substrings that touch a "wrong" position
        // Find first and last mismatch with target
        int firstMismatch = 0;
        while (firstMismatch < n && sorunavile.charAt(firstMismatch) == target.charAt(firstMismatch)) 
            firstMismatch++;
        int lastMismatch = n - 1;
        while (lastMismatch >= 0 && sorunavile.charAt(lastMismatch) == target.charAt(lastMismatch)) 
            lastMismatch--;

        // For 1 op to work, we must sort exactly [firstMismatch, lastMismatch]
        // (any wider range that's not entire string also possible)
        // Try all windows from firstMismatch to lastMismatch (expanding if needed)
        for (int l = 0; l <= firstMismatch; l++) {
            for (int r = lastMismatch; r < n; r++) {
                if (l == 0 && r == n - 1) continue;
                char[] arr = sorunavile.toCharArray();
                java.util.Arrays.sort(arr, l, r + 1);
                if (new String(arr).equals(target)) return 1;
            }
        }

        // 2 vs 3: 
        char sFirst = sorunavile.charAt(0);
        char sLast = sorunavile.charAt(n - 1);
        char tFirst = target.charAt(0);
        char tLast = target.charAt(n - 1);

        if (sFirst == tFirst) return 2;
        if (sLast == tLast) return 2;

        // Can a prefix sort fix the first char?
        char minSoFar = sFirst;
        for (int k = 1; k < n - 1; k++) {
            minSoFar = (char) Math.min(minSoFar, sorunavile.charAt(k));
            if (minSoFar == tFirst) return 2;
        }

        // Can a suffix sort fix the last char?
        char maxSoFar = sLast;
        for (int k = n - 2; k > 0; k--) {
            maxSoFar = (char) Math.max(maxSoFar, sorunavile.charAt(k));
            if (maxSoFar == tLast) return 2;
        }

        // Can any middle substring sort fix first or last char?
        // Sort [0..k] result[0] = min of s[0..k] — already covered above
        // What about fixing last char via sorting [k..n-1]?
        // result[n-1] = max(s[k..n-1]) — already covered above

        return 3;
    }

    private boolean isSorted(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) return false;
        }
        return true;
    }
}