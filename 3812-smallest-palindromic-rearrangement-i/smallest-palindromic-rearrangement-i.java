class Solution {
    public String smallestPalindrome(String s) {

        // Step 1: Count frequency of each character
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        char middle = '\0';

        // Step 2: Build the first half and find the middle character
        for (int i = 0; i < 26; i++) {

            // Add half of the occurrences to the first half
            while (freq[i] >= 2) {
                firstHalf.append((char) ('a' + i));
                freq[i] -= 2;
            }

            // If one character is left, it goes in the middle
            if (freq[i] == 1) {
                middle = (char) ('a' + i);
            }
        }

        // Step 3: Build the answer
        StringBuilder answer = new StringBuilder();

        answer.append(firstHalf);

        if (middle != '\0') {
            answer.append(middle);
        }

        answer.append(new StringBuilder(firstHalf).reverse());

        return answer.toString();
    }
}