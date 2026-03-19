class Solution {
    public int numberOfSubmatrices(char[][] grid) {
    
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] prevX = new int[n][m];
        int[][] prevY = new int[n][m];
        
        int result = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                int currentX = (grid[i][j] == 'X') ? 1 : 0;
                int currentY = (grid[i][j] == 'Y') ? 1 : 0;

                prevX[i][j] = currentX;
                prevY[i][j] = currentY;

                if(i > 0){
                    prevX[i][j] += prevX[i - 1][j];
                    prevY[i][j] += prevY[i - 1][j];
                }
                if(j > 0){
                    prevX[i][j] += prevX[i][j - 1];
                    prevY[i][j] += prevY[i][j - 1];
                }
                if(i > 0 && j > 0){
                    prevX[i][j] -= prevX[i - 1][j - 1];
                    prevY[i][j] -= prevY[i - 1][j - 1];
                }

                if(prevX[i][j] == prevY[i][j] && prevX[i][j] > 0){
                    result += 1;
                }
            }
        }
        return result;

    }
}