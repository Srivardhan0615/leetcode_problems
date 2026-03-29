class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] c = s1.toCharArray();
        
        if (new String(c).equals(s2)) return true;

        swap(c, 0, 2);
        if (new String(c).equals(s2)) return true;

        swap(c, 1, 3);
        if (new String(c).equals(s2)) return true;

        swap(c, 0, 2);
        if (new String(c).equals(s2)) return true;
        
        return false;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}