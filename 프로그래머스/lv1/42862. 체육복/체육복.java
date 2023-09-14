import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] std = new int[n]; // 학생 배열
        int answer = 0; // 체육복을 가지고 있는 학생 수
        for (int i = 0; i < n; i++) {
            std[i] = 1;
        }
        for (int i = 0; i < reserve.length; i++) { // 여분 체육복 가지고 있는 학생
            std[reserve[i] - 1]++;
        }
        for (int i = 0; i < lost.length; i++) { // 체육복을 도난당한 학생
            std[lost[i] - 1]--;
        }
        for (int i = 0; i < n; i++) { // 여분 체육복 나눠주기
            if (std[i] == 1) continue;
            if (i - 1 >= 0 && std[i - 1] == 0 && std[i] == 2) {
                std[i - 1] = 1;
                std[i] = 1;
            } else if (i + 1 < n && std[i + 1] == 0 && std[i] == 2) {
                std[i + 1] = 1;
                std[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) { // 여분 체육복을 모두 나눠준 후 체육복을 가지고 있는 학생 수 구하기
            if (std[i] > 0) answer++;
        }
        return answer;
    }
}