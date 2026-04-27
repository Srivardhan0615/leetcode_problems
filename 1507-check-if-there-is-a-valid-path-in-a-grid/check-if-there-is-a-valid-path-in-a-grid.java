class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] moves = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };

        int[][] street = {
            {},
            {2,3},
            {0,1},
            {2,1},
            {3,1},
            {2,0},
            {3,0}
        };

        int[] opposite = {1,0,3,2};

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];

            if (i == m-1 && j == n-1) return true;

            for (int d : street[grid[i][j]]) {
                int ni = i + moves[d][0];
                int nj = j + moves[d][1];

                if (ni < 0 || nj < 0 || ni >= m || nj >= n || visited[ni][nj])
                    continue;

                // check reverse connection
                for (int nd : street[grid[ni][nj]]) {
                    if (nd == opposite[d]) {
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni,nj});
                        break;
                    }
                }
            }
        }
        return false;
    }
}