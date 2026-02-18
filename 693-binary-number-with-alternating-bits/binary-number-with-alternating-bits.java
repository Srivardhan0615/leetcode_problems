class Solution {
    public boolean hasAlternatingBits(int n) {

        int result = n ^ (n>>1);

        return ((result+1) & result) == 0;
      
        
    }
}