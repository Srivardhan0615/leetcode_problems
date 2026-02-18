class Solution {
    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        
        StringBuilder sb = new StringBuilder();

        while(i >= 0 || j >= 0 || c == 1){
            if(i >= 0){
                c = c + a.charAt(i--) - '0';
            }if(j >= 0){
                c = c +b.charAt(j--) - '0';
            }
            sb.append(c % 2);
            c = c/2;

        }
        sb.reverse();
        return sb.toString();
        
    }
}