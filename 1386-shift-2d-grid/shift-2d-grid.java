class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;

        while (k-- > 0) {

            int last = grid[rows - 1][cols - 1];

            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0; j--) {

                    if (i == 0 && j == 0)
                        continue;

                    if (j == 0)
                        grid[i][j] = grid[i - 1][cols - 1];
                    else
                        grid[i][j] = grid[i][j - 1];
                }
            }

            grid[0][0] = last;
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++)
                row.add(grid[i][j]);
            ans.add(row);
        }

        return ans;
    }
}