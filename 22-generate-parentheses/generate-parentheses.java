class Solution {

    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        generate("",0,0,n);

        return ans;
        
    }
    public void generate(String str, int open, int close, int n){

        if(str.length() == 2 * n){
            ans.add(str);
        }

        if(open < n){
            generate(str + "(", open + 1, close, n);
        }

        if(close < open){
            generate(str + ")", open, close + 1, n);
        }
    }
}