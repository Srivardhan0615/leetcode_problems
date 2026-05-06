class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        for(int i = 0; i < m; i++){
            gravity(i, n, boxGrid);
        }

        char[][] result = new char[n][m];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result[j][m - 1 - i] = boxGrid[i][j];
            }
        }
        return result;
        
    }
    public void gravity(int row, int n, char[][] grid){
        int emptySlot = n - 1;

        for(int i = n - 1; i >= 0; i--){
            if(grid[row][i] == '#'){
                grid[row][i] = '.';
                grid[row][emptySlot] = '#';
                emptySlot--;
            }else if(grid[row][i] == '*'){
                emptySlot = i - 1;
            }
        }
    }
}