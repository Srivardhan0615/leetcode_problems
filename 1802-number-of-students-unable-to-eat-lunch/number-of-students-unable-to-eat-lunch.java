import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> stu = new LinkedList<>();

        for (int i : students) {
            stu.offer(i);
        }
        int i = 0;
        int count = 0; 
        while (!stu.isEmpty() && count < stu.size()) {

            if(sandwiches[i] == stu.peek()){
                stu.poll();
                count = 0;
                i++;  
            }else{
                stu.offer(stu.poll());
                count++;
            }
        }

        return count;
    }
}