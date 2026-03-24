import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 1. 해시맵 만들기
        HashMap<String, Integer> countMap = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }
        
        for (String key : countMap.keySet()) {
            answer *= (countMap.get(key) + 1);
        }
        
        return answer - 1;
    }
}