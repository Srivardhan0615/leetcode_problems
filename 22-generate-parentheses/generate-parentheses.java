class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate("",0,0,n, list);
        return list;
    }
    public void generate(String str, int open, int close, int n, List<String> list){

        if(str.length() == 2 *n){
            list.add(str);
            return;
        }
        if(open < n){
            generate(str + "(", open + 1,close,n,list);
        }
        if(close < open){
            generate(str + ")", open, close + 1,n, list);
        }
    }
}