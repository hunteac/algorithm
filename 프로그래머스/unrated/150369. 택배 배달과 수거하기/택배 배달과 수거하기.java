import java.util.*;

class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
     
        long answer = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            // 가장 먼 거리부터 배달, 수거 처리
            while (deliveries[i] > 0 || pickups[i] > 0) {
                deliveries[i] -= cap;
                pickups[i] -= cap;
                answer += (i + 1) * 2; // 왕복 거리 더하기
            }    
            
            if (i == 0) break;
            
            // 초과분 처리
            deliveries[i - 1] += deliveries[i];
            pickups[i - 1] += pickups[i];    
        }
        
        return answer;
    }
}