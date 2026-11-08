import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {
    static void main() {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = solution2(operations);
        System.out.println(Arrays.toString(answer));
    }
    static int[] solution(String[] operations){
        int[] answer = new int[2];
        PriorityQueue<Integer> MinPq = new PriorityQueue<>();
        PriorityQueue<Integer> MaxPq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < operations.length; i++){
            if(operations[i].startsWith("I")){
                int num = Integer.parseInt(operations[i].substring(2));
                MaxPq.offer(num);
                MinPq.offer(num);
            }
            else{
                if(operations[i].charAt(2) == '-' && !MinPq.isEmpty()){
                    MaxPq.remove(MinPq.peek());
                    MinPq.poll();
                }
                else if(!MaxPq.isEmpty()){
                    MinPq.remove(MaxPq.peek());
                    MaxPq.poll();
                }
            }
        }
        if(!MaxPq.isEmpty() && !MinPq.isEmpty()){
            answer[0] = MaxPq.poll();
            answer[1] = MinPq.poll();
            return answer;
        }
        answer = new int[]{0, 0};
        return answer;
    }
    static int[] solution2(String[] operations){
        TreeMap<Integer, Integer> map = new TreeMap<>();   // 값 -> 개수

        for (String op : operations) {
            if (op.startsWith("I")) {
                int num = Integer.parseInt(op.substring(2));
                map.merge(num, 1, Integer::sum);
            } else {
                if (map.isEmpty()) continue;
                int key = op.charAt(2) == '-' ? map.firstKey() : map.lastKey();
                if (map.merge(key, -1, Integer::sum) == 0) map.remove(key);
            }
        }
        if (map.isEmpty()) return new int[]{0, 0};
        return new int[]{map.lastKey(), map.firstKey()};
    }
}