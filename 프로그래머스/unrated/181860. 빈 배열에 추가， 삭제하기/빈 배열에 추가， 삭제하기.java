import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        int len = 0; // 배열 길이
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) { // 출력 배열 길이 구하기
            if (flag[i]) len += arr[i] * 2;
            else len -= arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    list.add(arr[i]);
                }
            } else {
                int size = list.size(); // 리스트의 size는 가변적이기 때문에 변수로 설정
                for (int j = size - 1; j > size - 1 - arr[i]; j--) {
                    list.remove(j);
                }
            }
        }
        int[] answer = new int[len];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}