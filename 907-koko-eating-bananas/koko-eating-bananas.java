class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 0;
        int right = 1;

        for(int p : piles){
            right = Math.max(right, p);
        }

        int ans = right;
        while(left <= right){

            int mid = left + (right - left)/2;

            int hours = 0;

            for(int p : piles){

                hours += Math.ceil((double)p / mid);
            }

            if(hours <= h){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}