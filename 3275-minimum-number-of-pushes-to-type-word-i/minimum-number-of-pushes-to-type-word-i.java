class Solution {
    public int minimumPushes(String word) {
        
        int n = word.length();

        int q = n/8;
        int r = n%8;

        int res = 0;

        for(int i = 1; i <= q; i++){

            res += 8 * i;
            
        }
        
        return res + (r *(q + 1));
    }
}