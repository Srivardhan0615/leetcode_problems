class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        Integer[] arr = set.toArray(new Integer[0]);
        
        Arrays.sort(arr);
        int count = 1;
        int max = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i - 1] == 1){
                count++;
                max = Math.max(max, count);
            }else{
                count = 1;
            }
        }
        return max;
        
    }
}