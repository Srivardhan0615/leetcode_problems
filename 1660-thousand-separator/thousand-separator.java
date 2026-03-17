class Solution {
    public String thousandSeparator(int n) {
        if(n < 1000){
            return String.valueOf(n);
        }
        StringBuilder sb = new StringBuilder();

        String str = String.valueOf(n);
        int n1 = str.length();
        int count = 0;
        for(int i = n1 - 1; i >= 0; i--){
            sb.append(str.charAt(i));
            count++;
            if(count == 3 && i != 0){
                sb.append(".");
                count = 0;
            }
        }
        sb.reverse();
        return sb.toString();

    }
}