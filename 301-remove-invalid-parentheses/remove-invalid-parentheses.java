class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        while(!queue.isEmpty()){
            
            int size = queue.size();
            List<String> level = new ArrayList<>();

            for(int i = 0; i < size; i++){

                level.add(queue.poll());
            }
            for(String current : level){
                if(isValid(current)){
                    result.add(current);
                }
            }
            if(!result.isEmpty()){
                break;
            }
            for(String current : level){
                for(int i = 0; i < current.length(); i++){
                    char ch = current.charAt(i);

                    if(ch != '(' && ch != ')'){
                        continue;
                    }

                    String next = current.substring(0,i) + current.substring(i+1);

                    if(visited.add(next)){
                        queue.add(next);
                    }
                }
            }

        }
        return result;
    }
    public static boolean isValid(String str){

        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){

            if(c == '('){
                stack.push('(');
            }else if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }

        }
        return stack.isEmpty();
    }
}