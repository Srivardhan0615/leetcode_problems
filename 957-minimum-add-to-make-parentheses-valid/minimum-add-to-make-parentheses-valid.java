class Solution {
    public int minAddToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();

        int count = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push('(');
            }else if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else{
                stack.push(')');
            }
        }

        while(!stack.isEmpty()){
            stack.pop();
            count++;
        }
        return count;
    }
}