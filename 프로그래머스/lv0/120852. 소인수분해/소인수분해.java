import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] flag = new boolean[n + 1];
        int[] arr = new int[n + 1];
        for (int i = 2; i < arr.length; i++) {
            flag[i] = true;
            arr[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (flag[i] && n % i == 0) list.add(i);
            else continue;
            for (int j = i * i; j <= n; j += i) { // 에라토스테네스의 체 활용
                flag[j] = false;   
            }
        }
        return list.stream().mapToInt(i -> i).toArray(); // 리스트 -> 배열 변환
    }
}