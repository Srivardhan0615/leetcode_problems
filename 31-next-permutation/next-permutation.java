class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int i = n - 2;

        // Step 1: find pivot
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        // Step 2: find next greater element
        if(i >= 0){
            int j = n - 1;
            while(nums[j] <= nums[i]){
                j--;
            }

            swap(nums, i, j);
        }

        // Step 3: reverse right part
        reverse(nums, i+1, n-1);
    }

    void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}