class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        boolean[] jewel_arr = new boolean[128];
        for(char c : jewels.toCharArray()){
            jewel_arr[c] = true;
        }
        int count = 0;
        for(char c : stones.toCharArray()){
            if(jewel_arr[c]){
                count++;
            }
        }
        return count;
    }
}