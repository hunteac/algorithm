import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<String, Integer> hMap = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) { // 문자별 최소 횟수 구하기
            for (int j = 0; j < keymap[i].length(); j++) {
                String s = String.valueOf(keymap[i].charAt(j));
                if (hMap.containsKey(s)) hMap.put(s, Math.min(hMap.get(s), j + 1));
                else hMap.put(s, j + 1);
            }
        }
        
        Outer: for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                String s = String.valueOf(targets[i].charAt(j));
                if (!hMap.containsKey(s)) {
                    answer[i] = -1;
                    continue Outer;
                }
                sum += hMap.get(s);
            }
            answer[i] = sum;
        }
        return answer;
    }
}