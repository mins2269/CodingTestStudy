import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        int answer = solution(user_id, banned_id);
        System.out.println(answer);
    }
    static int solution(String[] user_id, String[] banned_id){
        int answer = 0;
        // banned_id를 인덱스로 나타내고 해당 인덱스 당 제재 당한 유저 아이디
        List<List<Integer>>  list = new ArrayList<>();
        for(int i = 0; i < banned_id.length; i++){
            list.add(new ArrayList<>());
            for(int j = 0; j < user_id.length; j++){
                boolean check = true;
                // 문자열 길이로 1차 거른다
                if(banned_id[i].length() == user_id[j].length()){
                    // 문자열 하나하나 비교
                    for(int k = 0; k < banned_id[i].length(); k++){
                        if(banned_id[i].charAt(k) != user_id[j].charAt(k) && banned_id[i].charAt(k) != '*'){
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        list.get(i).add(j);
                    }
                }
            }
        }

        Set<Set<Integer>> states = new HashSet<>();
        states.add(new HashSet<>());
        // {{0,1}, {0,2}, {3,4}, {3,4}}
        for (List<Integer> candidates : list) {
            //{ }
            Set<Set<Integer>> next = new HashSet<>();
            for (Set<Integer> set : states) {
                // 0, 1
                for (int idx : candidates) {
                    if(!set.contains(idx)){
                        // set의 복사본
                        Set<Integer> temp = new HashSet<>(set);
                        temp.add(idx);
                        next.add(temp);
                    }
                }
            }
            states = next;
        }
        return states.size();
    }
}