class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> list = new ArrayList<>();

        if(nums.length == 0) return list;
        int j = nums[0];

        for(int i = 1; i <= nums.length; i++){
            if(i == nums.length || nums[i] != (nums[i - 1] +1)){
                if(j == nums[i - 1]){
                    list.add(String.valueOf(j));
                }else{
                    list.add(j + "->" + nums[i - 1]);
                }
                if(i < nums.length) j = nums[i];

            }
        }
        return list;

        
    }
}