import java.util.*;

public class Solution {
    static void main(){
        int brown = 10;
        int yellow = 2;
        int[] answer = solution2(brown, yellow);
        System.out.println(Arrays.toString(answer));
    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;
        int a = 0;
        int b = 0;
        for(int i = 3; i < total / 2; i++){
            int row = 0;
            int col = 0;
            if(total % i == 0){
                a = i;
                if(total % (total / i) == 0){
                    b = total / i;
                    if(a >= b) {
                        row = a;
                        col = b;
                    }else{
                        row = b;
                        col = a;
                    }
                    if((2 * row) + (2 * (col-2)) == brown){
                        return new int[]{row, col};
                    }
                }
            }
        }
        return answer;
    }
    public static int[] solution2(int brown, int yellow) {
        int total = brown + yellow;
        // 세로열을 기준으로 for문을 돈다. 그리고 그 값의 제곱을 total 이하여야한다는 조건을 둔다
        // 이유는 세로는 가로보다 이하여야하고 만약 그 둘의 값이 같을 때 제곱값이므로
        for(int col = 3; col * col <= total / 2; col++){
            if(total % col != 0){
                continue;
            }
            int row = total / col;
            if((row - 2) * (col - 2) == yellow){
                return new int[]{row, col};
            }
        }
        return new int[]{};
    }
}
