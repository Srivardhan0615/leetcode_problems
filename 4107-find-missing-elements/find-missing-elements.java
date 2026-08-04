class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums){
            if(i < min){
                min = i;
            }
        }

        for(int i : nums){
            if(i > max){
                max = i;
            }
        }

        for(int i : nums){
            set.add(i);
        }

        for(int i = min; i <= max; i++){
            if(set.contains(i) == false){
                list.add(i);
            }
        }
        return list;
        
    }
}