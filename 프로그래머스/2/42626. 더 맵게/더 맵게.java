import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean chk = false;
        int answer = 0;
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int a = 0;
        int b = 0;
        
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                a = pq.poll();
                if (a >= K) {
                    chk = true;
                    break;
                }
            } else {
                a = pq.poll(); // 가장 맵지 않은 음식
                b = pq.poll(); // 두 번째로 맵지 않은 음식
                if (a >= K) {
                    chk = true;
                    break; // 모든 음식의 스코빌 지수가 K이상이면 종료    
                } else {
                    int c = a + (b * 2); // 음식 섞기
                    pq.add(c);
                    answer++;
                }
            }
        }
        
        if (chk) return answer;
        else return -1;
    }
}