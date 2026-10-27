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
    static int solution2(int[] numbers, int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0); // 아직 아무 숫자도 안 쓴 상태의 합

        for (int num : numbers) {
            int size = q.size(); // 현재 레벨에 있는 합의 개수
            for (int i = 0; i < size; i++) {
                int sum = q.poll();
                q.offer(sum + num);
                q.offer(sum - num);
            }
        }

        int answer = 0;
        for (int sum : q) {
            if (sum == target) answer++;
        }
        return answer;
    }
}