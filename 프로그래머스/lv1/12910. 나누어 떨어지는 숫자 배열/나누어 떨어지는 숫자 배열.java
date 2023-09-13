import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) list.add(arr[i]);
        }
        Collections.sort(list); // 오름차순 정렬
        if (list.size() == 0) list.add(-1); // 나누어 떨어지는 원소가 없다면 -1 반환
        return list.stream().mapToInt(i -> i).toArray();
    }
}