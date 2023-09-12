import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] tmp = new int[rank.length];
        int first = 0; // 1등 순서
        int second = 0; // 2등 순서
        int third = 0; // 3등 순서
        for (int i = 0; i < rank.length; i++) {
            tmp[i] = rank[i];
            if (!attendance[i]) tmp[i] = 101;
        }
        Arrays.sort(tmp);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < rank.length; j++) {
                if (tmp[i] == rank[j]) {
                    if (i == 0) { // 1등 순서 구하기
                        first = j;
                        break;
                    } else if (i == 1) { // 2등 순서 구하기
                        second = j;
                        break;
                    } else { // 3등 순서 구하기
                        third = j;
                        break;
                    }
                }
            }
        }
        return (10000 * first) + (100 * second) + third;
    }
}