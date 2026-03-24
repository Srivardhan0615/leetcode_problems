class Solution {
    public int[][] constructProductMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        long product = 1;
        int size = m * n;
        int[] arr = new int[size];
        int mod = 12345;

        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[idx] = grid[i][j];
                idx++;
            }
        }

        long[] prefix = new long[size];
        long[] sufix = new long[size];
        prefix[0] = 1;

        for(int i = 1; i < size; i++){
            prefix[i] = (prefix[i-1] * arr[i-1]) % mod;
        }
        sufix[size - 1] = 1;

        for(int i = size - 2; i >=0; i--){
            sufix[i] = (sufix[i+1] * arr[i+1]) % mod;
        }

        int vdk = 0;
        int res[][] =  new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                res[i][j] = (int)(prefix[vdk] * sufix[vdk]) % mod;
                vdk++;
            }
        }
        return res;

    }
}