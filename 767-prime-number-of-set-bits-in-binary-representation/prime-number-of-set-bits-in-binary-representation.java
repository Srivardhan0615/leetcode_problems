class Solution {
    public int countPrimeSetBits(int left, int right) {

        int mask = 665772;
        int count = 0;

        for(int n = left; n <= right; n++){
            if(((mask >>Integer.bitCount(n)) & 1) == 1){
                count++;
            }

        }
        return count;
        
    }
}