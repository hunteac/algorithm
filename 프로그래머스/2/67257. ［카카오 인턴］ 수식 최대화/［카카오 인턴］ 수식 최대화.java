import java.util.*;

class Solution {
    static List<String> exp = new LinkedList<>(); // 표현식
    static HashMap<Integer, String> map;
    static boolean[] visited; // 방문 처리
    static int[] p; // 순열
    static long max; // 최댓값
    
    // 순열 알고리즘을 통한 우선순위 구하기
    static void permutation(int idx) {
        if (idx == p.length) {
            List<String> tmp = new LinkedList<>();
            for (int i = 0; i < exp.size(); i++) {
                tmp.add(exp.get(i));
            }

            for (int i = 0; i < p.length; i++) {
                
                String s = map.get(p[i]); // 우선순위대로 연산자 뽑기
                
                int idx2 = 0;
                
                while (true) {
                    if (tmp.get(idx2).equals(s)) {
                        long before = Long.parseLong(tmp.remove(--idx2)); // 연산자 이전 숫자
                        tmp.remove(idx2); // 연산자
                        long after = Long.parseLong(tmp.remove(idx2)); // 연산자 다음 숫자
                        
                        // 연산
                        if (s.equals("*")) tmp.add(idx2, String.valueOf(before * after));
                        else if (s.equals("+")) tmp.add(idx2, String.valueOf(before + after));
                        else tmp.add(idx2, String.valueOf(before - after));
                    }
                    
                    idx2++;
                    
                    if (idx2 == tmp.size()) break;
                }       
            }
            
            max = Math.max(max, Math.abs(Long.parseLong(tmp.get(0)))); // 최댓값 구하기
            
            return;
        }
        
        for (int i = 0; i < p.length; i++) {
            if (visited[i]) continue;
            visited[i] = true; // 원소 선택
            p[idx] = i;
            permutation(idx + 1);
            visited[i] = false; // 원소 선택 X
        }
    }
    
    public long solution(String expression) {
        long answer = 0;
        
        map = new HashMap<>();
        
        int idx = 0;
        
        for (int i = 0; i < expression.length(); i++) {
            String s = String.valueOf(expression.charAt(i));
            if (s.equals("+") || s.equals("-") || s.equals("*")) {
                if (!map.containsValue(s)) {
                    map.put(idx, s);    
                    idx++;
                } 
            }
        }
        
        // 문자열 쪼개기(숫자, 연산자 분리)
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < expression.length(); i++) {
            char temp = expression.charAt(i);
            if (temp == '-' || temp == '*' || temp == '+') {
                exp.add(sb.toString());
                sb = new StringBuilder();
                exp.add(String.valueOf(temp));
            } else {
                sb.append(temp);
            }
        }
        exp.add(sb.toString());
        
        visited = new boolean[map.size()];
        p = new int[map.size()];
        
        permutation(0);
    
        return max;
    }
}