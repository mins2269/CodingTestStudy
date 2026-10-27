import java.util.Arrays;

public class Solution {
    static void main() {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int answer = solution(people, limit);
        System.out.println(answer);
    }
    static int solution(int[] people, int limit){
        int answer = 0;
        Arrays.sort(people);
        //50 50 70 80
        int left = 0;
        int right = people.length-1;
        while(left <= right){
            if(people[left] +  people[right] <= limit){
                left++;
            }
            right--;
            answer++;
        }
        return answer;
    }
}
