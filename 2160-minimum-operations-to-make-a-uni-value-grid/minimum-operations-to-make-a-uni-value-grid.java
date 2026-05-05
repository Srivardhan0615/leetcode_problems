class Solution {
    public int minOperations(int[][] grid, int x) {

        int n = grid.length;
        int m = grid[0].length;

        int arr[] = new int[m * n];
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[k] = grid[i][j];
                k++;
            }
        }
        Arrays.sort(arr);

        int operation = 0;

        int rem = arr[0] % x;
        for(int i : arr){
            if( i % x != rem) return -1;
        }
        int p = arr.length;
        int middle = arr[p/2];
        for(int i : arr){
            operation += Math.abs(i - middle)/x;
        }
        return operation;
        
    }
}