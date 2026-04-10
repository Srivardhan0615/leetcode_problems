import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> stu = new LinkedList<>();
        Stack<Integer> food = new Stack<>();

        for (int i : students) {
            stu.offer(i);
        }

   
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            food.push(sandwiches[i]);
        }

        int count = 0; 

        while (!stu.isEmpty() && count < stu.size()) {

            if (stu.peek().equals(food.peek())) {
                stu.poll();
                food.pop();
                count = 0; 
            } else {
                stu.offer(stu.poll());
                count++;
            }
        }

        return count; 
    }
}