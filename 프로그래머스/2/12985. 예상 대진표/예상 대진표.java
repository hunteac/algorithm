import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1; // 라운드
        
        int left = Math.min(a, b); // 대진표 왼쪽 위치
        int right = Math.max(a, b); // 대진표 오른쪽 위치
        
        while (true) {
            if (left % 2 == 1 && left + 1 == right) break;
                
            if (left % 2 == 0) left /= 2;
            else left = (left + 1) / 2;
            
            if (right % 2 == 0) right /= 2;
            else right = (right + 1) / 2;
            
            answer++;
        }
        
        return answer;
    }
}