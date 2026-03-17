class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <=s.length(); i++){
            for(int j = i+1; j <=s.length(); j++){
                String str = s.substring(i,j);
                sb.append(str);
                String rev = sb.reverse().toString();
                if(rev.equals(str)) count++;
                sb.delete(0, sb.length());

            }
        }
        return count;
        
    }
}