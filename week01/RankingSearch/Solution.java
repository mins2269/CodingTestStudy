package week01.RankingSearch;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static void main(){
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = new int[query.length];
        answer = solution(info,query);
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }
    public static int[] solution(String[] info, String[] query){
        int[] answer = new int[query.length];
        String[][] separatedInfo = new String[info.length][5];
        for(int i=0; i<info.length; i++){
            String targetInfo = info[i];
            separatedInfo[i] = targetInfo.split(" ");
        }

        String[] separatedQuery = new String[5];
        for(int i=0; i<query.length; i++){
            List<Integer> separatedIndexes = new ArrayList<>();
            String targetQuery = query[i];
            separatedQuery= targetQuery.replace(" and ", " ").split("\\s+");
            compareLanguage(separatedInfo, separatedQuery[0],separatedIndexes);
            compareOccupation(separatedInfo, separatedQuery[1], separatedIndexes);
            compareHistory(separatedInfo, separatedQuery[2], separatedIndexes);
            compareFodd(separatedInfo, separatedQuery[3], separatedIndexes);
            compareScore(separatedInfo, separatedQuery[4], separatedIndexes);
            answer[i] = separatedIndexes.size();
        }
        return answer;
    }
    static void compareLanguage(String[][] separatedInfo, String separatedQuery,  List<Integer> separatedIndexes){
        for(int j=0; j<separatedInfo.length; j++){
            if(separatedInfo[j][0].equals(separatedQuery) || separatedQuery.equals("-")){
                separatedIndexes.add(j);
            }
        }
    }
    static void compareOccupation(String[][]  separatedInfo, String separatedQuery, List<Integer> separatedIndexes){
        separatedIndexes.removeIf(index -> !separatedInfo[index][1].equals(separatedQuery) && !separatedQuery.equals("-"));
    }
    static void compareHistory(String[][] separatedInfo, String separatedQuery, List<Integer> separatedIndexes){
        separatedIndexes.removeIf(index -> !separatedInfo[index][2].equals(separatedQuery) && !separatedQuery.equals("-"));
    }
    static void compareFodd(String[][] separatedInfo, String separatedQuery, List<Integer> separatedIndexes){
        separatedIndexes.removeIf(index -> !separatedInfo[index][3].equals(separatedQuery) && !separatedQuery.equals("-"));
    }
    static void compareScore(String[][]  separatedInfo, String separatedQuery, List<Integer> separatedIndexes){
        separatedIndexes.removeIf(index -> Integer.parseInt(separatedInfo[index][4]) < Integer.parseInt(separatedQuery));
    }
}