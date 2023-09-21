import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>(); // 중복 제거
    static boolean[] visited; // 방문 체크
    static char[] paper; // 종이 조각
        
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        paper = new char[numbers.length()];
        
        for (int i = 0; i < numbers.length(); i++) {
            paper[i] = numbers.charAt(i);
        }
        
        permutation("", 0);
        
        return set.size();
    }

    // 완전 탐색 메소드
    static void permutation(String s, int idx) {
        // 문자열이 공백이 아니라면 정수로 형변환 하고 소수 판별 후 set에 담기
        if (!s.equals("")) {
            int num = Integer.parseInt(s);
            if (isPrime(num)) set.add(num);
        }
        if (idx == paper.length) return; // 범위를 벗어나면 return
        
        for (int i = 0; i < paper.length; i++) {
            if (visited[i]) continue;
                visited[i] = true; // 방문 체크
                permutation(s + paper[i], idx + 1); // 문자열 더하고 재귀
                visited[i] = false; // 백트래킹
        }
    }
    
    // 소수 판별 메소드
    static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}