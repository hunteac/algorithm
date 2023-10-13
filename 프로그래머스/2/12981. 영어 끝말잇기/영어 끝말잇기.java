import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> used = new HashSet<>();
        int[] answer = new int[2];

        int cnt = 1; // 차례
        used.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            if (i % n == 0) cnt++;
             
            String w1 = words[i - 1]; // 이전 단어
            String w2 = words[i]; // 현재 단어
            if (w1.charAt(w1.length() - 1) != w2.charAt(0) || used.contains(w2)) { // 끝 글자가 다르거나 이미 사용한 단어라면
                if ((i + 1) % n == 0) answer[0] = (i + 1) / cnt; // 실수한 사람 번호
                else answer[0] = (i + 1) % n;
                answer[1] = cnt; // 현재 차례
                break;
            } else {
                used.add(w2);
            }
        }
        
        return answer;
    }
}