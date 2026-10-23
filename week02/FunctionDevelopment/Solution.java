import java.util.*;

public class Solution {
    static void main() {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1,1,1,1,1,1};
        int[] answer = solution(progresses, speeds);
        int[] answer2 = solution(progresses2, speeds2);
        System.out.println(Arrays.toString(answer));
        System.out.println(Arrays.toString(answer2));
    }
    static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int days;
            if((100 - progresses[i]) % speeds[i] != 0){
                days = ((100 - progresses[i]) / speeds[i]) + 1;
            }else{
                days = (100 -  progresses[i]) / speeds[i];
            }
            stack.offer(days);
        }
        while(!stack.isEmpty()){
            Integer cur = stack.poll();
            int count = 1;
            while(stack.peek() != null && cur >= stack.peek()){
                stack.poll();
                count++;
            }
            list.add(count);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}