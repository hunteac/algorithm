import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1; // 완성되지 않을 경우를 대비해 미리 -1 채우기
        }
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) list.add(arr[i]); // 이미 리스트에 포함된 수면 담지 않는다.
        }
        for (int i = 0; i < list.size(); i++) {
            answer[idx++] = list.get(i);
            if (idx == k) break; // 인덱스가 배열 길이와 같다면 반복문 탈출
        }
        return answer;
    }
}