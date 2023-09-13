import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        boolean chk = false;
        int sum = 0; // 부서 신청 금액 총합
        int tmpsum = 0; // 제외시킬 부서 금액 총합
        int idx = 1; // 제외시킬 부서 수
        int num = d.length;
        for (int i = 0; i < num; i++) {
            sum += d[i];
        }
        if (sum <= budget) return num; // 전체 부서 금액 총합이 예산 범위 내라면 전체 수 반환
        Arrays.sort(d);
        while (true) {
            tmpsum = 0;
            for (int i = num - 1; i > num - 1 - idx; i--) { // 신청 금액이 큰 부서부터 총합에서 제외함으로써 지원 가능한 최대 부서 수 구하기
                tmpsum += d[i];
            }
            if (sum - tmpsum <= budget) chk = true; // 금액 총합 - 제외 금액 총합이 예산 범위 내라면 true
            if (chk) break;
            idx++;
        }
        return num - idx;
    }
}