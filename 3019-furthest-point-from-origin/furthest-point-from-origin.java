import java.lang.Math;
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        
        int countR = 0;
        int countL = 0;
        int count = 0;
        for(char c : moves.toCharArray()){
            if(c == 'L'){
                countL++;
            }else if(c == 'R'){
                countR++;
            }else{
                count++;
            }
        }
        return Math.abs(countR - countL) + count;
    }
}