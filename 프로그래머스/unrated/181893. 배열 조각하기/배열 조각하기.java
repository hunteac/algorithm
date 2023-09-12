import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        int len = list.size();
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) { // 짝수 인덱스인 경우
                for (int j = query[i] + 1; j < len; j++) { // 인덱스 뒷부분 자르기
                    list.remove(query[i] + 1);
                }
            } else { // 홀수 인덱스인 경우
                for (int j = query[i] - 1; j >= 0; j--) { // 인덱스 앞부분 자르기
                    list.remove(j);   
                }
            }
            len = list.size();
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}