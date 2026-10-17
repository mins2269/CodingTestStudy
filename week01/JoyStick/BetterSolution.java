public class BetterSolution {
    static void main(){
        String name = "JAAAN";
        int answer = solution(name);
        System.out.print(answer);
    }
    public static int solution(String name) {
        int answer = 0;
        int n = name.length();
        // answer 초기화
        for (int i = 0; i < name.length(); i++) {
            int weight = name.charAt(i) - 'A';
            if (weight > 13) {
                answer += 26 - weight;
            } else {
                answer += weight;
            }
        }

        // 커서 이동 비용
        int move = n - 1;   // 기준선: 오른쪽으로만 끝까지 가는 경우
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') next++;   // i 뒤의 A 구간 건너뛰기

            int back = n - next;

            // 오른쪽으로 i칸 갔다가 되돌아오고(2*i), 왼쪽으로 next까지 간다(back)
            int a = 2 * i + back;
            // 왼쪽으로 먼저 갔다가 되돌아오고(2*back), 오른쪽으로 i칸 간다(i)
            int b = i + 2 * back;

            move = Math.min(move, Math.min(a, b));
        }

        // 최종 답 = (알파벳 변경 비용 합) + move
        answer += move;
        return answer;
    }
}