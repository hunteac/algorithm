import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int max = -1; // 다리를 건널 수 있는 최댓값
        
        for (int i = 0; i < stones.length; i++) {
            max = Math.max(max, stones[i]); // 징검다리 최대 내구도 구하기
        }
        
        int left = 1; // 최소 내구도
        int right = max; // 최대 내구도
        
        while (left <= right) { // 이분 탐색
            int mid = (left + right) / 2; // 중앙값
            int cnt = 0;
            boolean chk = true; // 다리를 건널 수 있는지 체크
            
            int tmp = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - mid < 0) cnt++; // 연속된 사라진 징검다리 개수 구하기
                else cnt = 0; // 초기화
                if (cnt >= k) { // 사라진 징검다리 개수가 k랑 같거나 k보다 크면
                    chk = false; // 다리를 건널 수 없다
                    break;
                }
            }

            if (chk) { // 다리를 건널 수 있으면
                left = mid + 1; // 사람 수 증가
                max = mid; // 현재 값 갱신
            } else { // 다리를 건널 수 없으면
                right = mid - 1; // 사람 수 감소
            }
        }
        
        return max;
    }
}