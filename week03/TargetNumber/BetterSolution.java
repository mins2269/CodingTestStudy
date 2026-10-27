public class BetterSolution {
    static int answer = 0;

    static void main() {
        int[] numbers = {4,1,2,1};
        int target = 4;
        int answer = solution(numbers, target);
        System.out.println(answer);
    }

    static int solution(int[] numbers, int target){
        dfs(numbers,target,0,0);
        return answer;
    }

    static void dfs(int[] numbers, int target, int sum, int idx){
        if(idx ==  numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        dfs(numbers,target,sum+numbers[idx],idx+1);
        dfs(numbers,target,sum-numbers[idx],idx+1);
    }
}