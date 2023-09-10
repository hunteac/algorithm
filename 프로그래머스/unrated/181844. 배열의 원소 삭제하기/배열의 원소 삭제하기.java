import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = Arrays.stream(delete_list).boxed().collect(Collectors.toList()); // 배열 -> 리스트 변환
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) answer.add(arr[i]);
        }
        return answer.stream().mapToInt(i -> i).toArray(); // 리스트 -> 배열 반환
    }
}