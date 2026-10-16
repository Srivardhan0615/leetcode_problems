class Solution {
    public String removeOuterParentheses(String s) {

        int count = -1;
        String str = "";
        for(char c : s.toCharArray()){

            if(c == '('){
                count++;
                if(count > 0){
                    str += "(";
                }
            }else if (c == ')'){
                
                if(count > 0){
                    str += ")";
                }
                count--;
            }
        }
        
        return str;
    }
}