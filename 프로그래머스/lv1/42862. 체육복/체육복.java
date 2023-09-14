import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] std = new int[n];
        int answer = 0;
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < n; i++) {
            std[i] = 1;
        }
        for (int i = 0; i < reserve.length; i++) {
            std[reserve[i] - 1]++;
        }
        for (int i = 0; i < lost.length; i++) {
            std[lost[i] - 1]--;
        }
        for (int i = 0; i < n; i++) {
            if (std[i] == 1) continue;
            if (i - 1 >= 0 && std[i - 1] == 0 && std[i] == 2) {
                std[i - 1] = 1;
                std[i] = 1;
            } else if (i + 1 < n && std[i + 1] == 0 && std[i] == 2) {
                std[i + 1] = 1;
                std[i] = 1;
            }
        }
        System.out.println(Arrays.toString(std));
        for (int i = 0; i < n; i++) {
            if (std[i] > 0) answer++;
        }
        return answer;
    }
}