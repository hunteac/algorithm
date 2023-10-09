import java.util.*;

class Solution {
    static HashMap<String, Integer> line = new HashMap<>();
    static String[] ch = { "A", "C", "F", "J", "M", "N", "R", "T" }; // 캐릭터
    static boolean[] visited; // 방문 체크
    static int cnt; // 경우의 수
        
    // 순열 알고리즘을 활용한 줄 세우기
    static void makeLine(String[] data, int idx) {
        if (idx == ch.length) {
            if (Take(data)) cnt++; // 조건을 만족하면 경우의 수 증가
            return;
        }
        
        for (int i = 0; i < ch.length; i++) {
            if (visited[i]) continue;
            visited[i] = true; // 원소 선택
            line.put(ch[i], idx);
            makeLine(data, idx + 1);
            visited[i] = false; // 원소 선택 X
        }
    }
    
    // 사진 찍기
    static boolean Take(String[] data) {
        boolean chk = true;
        for (int i = 0; i < data.length; i++) {
            String c1 = String.valueOf(data[i].charAt(0)); // 첫 번째 캐릭터 위치
            String c2 = String.valueOf(data[i].charAt(2)); // 두 번째 캐릭터 위치
            String comp = String.valueOf(data[i].charAt(3)); // 연산자
            int ans = data[i].charAt(4) - '0'; // 거리
            
            if (comp.equals("=")) {
                if (Math.abs(line.get(c1) - line.get(c2)) - 1 != ans) { // 조건의 간격과 다른 경우
                    chk = false;
                    break;
                }
            } else if (comp.equals(">")) {
                if (Math.abs(line.get(c1) - line.get(c2)) - 1 <= ans) { // 조건의 간격보다 가까운 경우
                    chk = false;
                    break;
                }
            } else {
                if (Math.abs(line.get(c1) - line.get(c2)) - 1 >= ans) { // 조건의 간격보다 먼 경우
                    chk = false;
                    break;
                }
            }
        }
        return chk; // 반환
    }
    
    public int solution(int n, String[] data) {
        visited = new boolean[8];
        
        cnt = 0;
        
        makeLine(data, 0);
        
        return cnt;
    }
}