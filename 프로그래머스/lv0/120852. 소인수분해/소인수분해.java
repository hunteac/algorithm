import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            cnt = 0;
            if (n % i == 0) {
                for (int j = 1; j <= i; j++) { // 소수 찾기
                    if (i % j == 0) cnt++;
                }
                if (cnt == 2) list.add(i);
            }    
        }
        return list.stream().mapToInt(i -> i).toArray(); // 리스트 -> 배열 변환
    }
}