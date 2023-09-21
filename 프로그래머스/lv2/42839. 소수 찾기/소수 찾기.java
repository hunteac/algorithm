import java.util.stream.*;
import java.util.*;

class Solution {
    static HashSet<String> set; // 중복 제거
    static boolean[] visited; // 방문 체크
    static boolean[] chk; // 소수 판별, false: 소수
    static String[] paper; // 종이 각 모음
    static String number;
    static int answer;
    static int len;
    
    static void bTrack(int idx) {
        String tmp = "";
        // 완전탐색
        for (int i = 0; i < len; i++) {
            if (!visited[i] || tmp.equals("") && paper[i].equals("0")) continue; // 11과 011은 같은 숫자
            tmp += paper[i];
        }
        if (!tmp.equals("")) set.add(tmp); // 중복 판별
        if (idx == len) return;
        
        // 재귀
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            paper[idx] = String.valueOf(number.charAt(i));
            bTrack(idx + 1);
            paper[idx] = "";
            bTrack(idx + 1);
            visited[i] = false;
        }
    }
    
    public int solution(String numbers) {
        answer = 0;
        len = numbers.length();
        set = new HashSet<>();
        chk = new boolean[(int) Math.pow(10, len)];
        visited = new boolean[len];
        paper = new String[len];
        number = numbers;
        
        // 에라토스테네스의 체
        chk[0] = chk[1] = true;
        for (int i = 2; i < chk.length; i++) {
            if (chk[i]) continue; 
            for (int j = i * 2; j < chk.length; j += i) {
                chk[j] = true;
            }
        }
        
        bTrack(0);
        
        for (String s : set) {
            if (!chk[Integer.parseInt(s)]) answer++;
        }
        
        return answer;
    }
}