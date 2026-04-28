class Solution {
    public int minOperations(int[][] grid, int x) {

        int n = grid.length;
        int m = grid[0].length;
        int operations = 0;
        int arr[] = new int[n * m];
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[k] = grid[i][j];
                k++;
            }
        }
        Arrays.sort(arr);

        int rem = arr[0] % x;
        for(int i : arr){
            if( i % x != rem) return -1;
        }

        int median = arr[arr.length/2];

        for(int i : arr){
            operations += Math.abs(i - median)/x;
        }
        return operations;
    }
}