import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> pMap = new HashMap<>(); // 참가자 명단 HashMap
        
        for (String p : participant) pMap.put(p, pMap.getOrDefault(p, 0) + 1); // 이름별 참가자 수 구하기
        for (String c : completion) pMap.put(c, pMap.get(c) - 1); // 완주한 참가자 제외

        String answer = ""; // 완주 못한 참가자
        for (String key : pMap.keySet()) {
            if (pMap.get(key) != 0)
                answer = key;
        }
        return answer;
    }
}