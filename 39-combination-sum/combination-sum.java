class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result =  new ArrayList<>();

        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remain, int start){

        if(remain == 0){
            result.add(new ArrayList<>(currentList));
        }

        if(remain < 0){
            return;
        }

        for(int i = start; i < candidates.length; i++){

            currentList.add(candidates[i]);

            backtrack(result, currentList, candidates, remain - candidates[i], i);

            currentList.remove(currentList.size() - 1);

        }
    }
}