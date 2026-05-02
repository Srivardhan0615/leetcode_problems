class Solution {
    public int rotatedDigits(int n) {

        int good = 0;

        for(int i = 1; i <= n; i++){
            if(check(i) == true){
                good++;
            }
        }
        return good;
        
    }
    public boolean check(int d){

        boolean hasChangedDigit = false;
        
        while(d > 0){
            int p = d % 10;

            if(p == 3 || p == 4 || p == 7){
                return false;
            }
            if(p == 2 || p == 5 || p == 6 || p == 9){

                hasChangedDigit = true;
            }
            d = d / 10;
        }
        return hasChangedDigit;
    }
}