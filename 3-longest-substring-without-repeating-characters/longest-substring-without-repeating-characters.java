class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int max = 0;
        int left= 0;
        char[] arr = s.toCharArray();

        for(int right = 0; right < arr.length; right++){
            while(set.contains(arr[right])){
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);
            max = Math.max(max, right - left + 1);
        }
        return max;
        
    }
}