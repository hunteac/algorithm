import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int idx = 0;
        int[] count = new int[N + 1]; // 스테이지별 도달한 플레이어
        int[] fail = new int[N + 1]; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어
        int[] answer = new int[N]; // 출력 배열
        double[] rate = new double[N + 1]; // 실패율
        double[] comp = new double[N + 1];
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] == N + 1) {
                count[N]++;
                continue;
            }
            count[stages[i]]++;
            fail[stages[i]]++;
        }
        for (int i = count.length - 1; i >= 2; i--) { // 스테이지별 도달 플레이어 수 구하기 
            count[i - 1] += count[i];
        }
        for (int i = 1; i < rate.length; i++) { // 스테이지별 실패율 구하기
            if (count[i] == 0) rate[i] = -1; // 실패율 0
            else rate[i] = (double) fail[i] / count[i];
            if (rate[i] == 0) rate[i] = -1; // 실패율 0
            comp[i] = rate[i];
        }
        Arrays.sort(comp); // 실패율 오름차순 정렬
        for (int i = comp.length - 1; i >= 0; i--) { // 실패율 높은 순으로 배치
            if (comp[i] == 0) continue;
            for (int j = 1; j < rate.length; j++) {
                if (comp[i] == rate[j]) {
                    answer[idx++] = j;
                    rate[j] = 0;
                    break;
                } 
            }
        }
        return answer;
    }
}