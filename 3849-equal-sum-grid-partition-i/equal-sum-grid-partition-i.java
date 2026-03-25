class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        long totalsum = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                totalsum += grid[i][j];
            }
        }

        if(totalsum % 2 == 1) return false;

        long target = totalsum/2;
        long currentsum = 0;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m; j++){
                currentsum += grid[i][j];
            }
            if(currentsum == target) return true;
        }

        currentsum = 0;

        for(int i = 0; i < m - 1; i++){
            for(int j = 0; j < n; j++){
                currentsum += grid[j][i];
            }
            if(currentsum == target) return true;
        }
        return false;
        
    }
}