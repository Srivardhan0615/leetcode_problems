class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<2)
        {
            return nums[0];
        }
        int skiplast[]=new int[n-1];
        int skipfirst[]=new int[n-1];
        for (int i=0;i<n-1;i++)
        {
            skiplast[i]=nums[i];
            skipfirst[i]=nums[i+1];
        }
        int lootskiplast=robhelper(skiplast,n-1);
        int lootskipfirst=robhelper(skipfirst,n-1);
        return Math.max(lootskiplast,lootskipfirst);
    }
    public int robhelper(int house[],int n)
    {
        if(n==0) return 0;
        if(n==1) return house[0];
        int[] dp=new int[n];
        dp[0]=house[0];
        dp[1]=Math.max(house[0],house[1]);
        for(int i=2;i<n;i++)
        {
            dp[i]=Math.max(dp[i-2]+house[i],dp[i-1]);
        }
        return dp[n-1];
    }
}