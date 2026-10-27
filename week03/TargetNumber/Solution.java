public class Solution {
    static int answer = 0;

    static void main() {
        int[] numbers = {4,1,2,1};
        int target = 4;
        int answer = solution(numbers, target);
        System.out.println(answer);
    }

    static int solution(int[] numbers, int target){
        Queue<Integer> q = new LinkedList<>();
        for (int number : numbers) {
            q.add(number);
        }

        dfs(q,target,0);
        return answer;
    }

    static void dfs(Queue<Integer> queue, int target, int sum){
        if(!queue.isEmpty()){
            int num = queue.poll();

            dfs(queue,target,sum - num);
            dfs(queue,target,sum + num);

        }else{
            if(sum == target){
                answer++;
            }
        }
    }
}
```