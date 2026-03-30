class Solution {
    public String convert(String s, int numRows) {

        if(numRows <= 1 || s.length() <= numRows){
            return s;
        }

        HashMap<Integer, StringBuilder> map = new HashMap<>();

        for(int i = 0; i < numRows; i++){
            map.put(i, new StringBuilder());
        }

        int currentrow = 0;
        int dir = -1;

        for(char c : s.toCharArray()){
            map.get(currentrow).append(c);

            if(currentrow == 0 || currentrow == numRows - 1){
                dir *= -1;
            }

            currentrow += dir;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            result.append(map.get(i));
        }
        return result.toString();
    }
}