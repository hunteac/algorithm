import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> pMap = new HashMap<>(); // 참가자 명단 HashMap
        for (int i = 0; i < participant.length; i++) {
            pMap.put(participant[i], 0);
        }
        for (int i = 0; i < participant.length; i++) { // 이름 별 참가자 수 구하기
            pMap.put(participant[i], pMap.get(participant[i]) + 1);
        }
        for (int i = 0; i < completion.length; i++) { // 완주한 참가자 제외시키기
            pMap.put(completion[i], pMap.get(completion[i]) - 1);
        }
        String p = ""; // 완주 못한 참가자
        for (int i = 0; i < participant.length; i++) { // 완주하지 못한 참가자 구하기
            if (pMap.get(participant[i]) == 1) {
                p = participant[i];
                break;
            }
        }
        return p;
    }
}