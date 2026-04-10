class Solution {
    public int firstUniqChar(String s) {

        int[] arr = new int[26];

        for(char c : s.toCharArray()){
            arr[ c - 'a']++;
        }
        int idx = -1;
        for(char c : s.toCharArray()){
            idx++;
            if(arr[c - 'a'] == 1){
                return idx; 
            }
        }
        return -1;
        
    }
}