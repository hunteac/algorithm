import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (list.isEmpty()) { // 빈 리스트면
                list.add(arr[i]); // arr[i] 리스트에 추가
                continue;
            } 
            if (list.get(list.size() - 1) == arr[i]) list.remove(list.size() - 1); // 리스트의 마지막 원소가 arr[i]와 같으면 리스트 마지막 원소 제거
            else if (list.get(list.size() - 1) != arr[i]) list.add(arr[i]); // 리스트의 마지막 원소가 arr[i]와 다르면 arr[i] 추가
        }
        if (list.size() == 0) list.add(-1); // 빈 리스트면 -1 출력을 위해 -1 담기
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i); // 배열로 원소들을 옮긴 후 출력
        }
        return answer;
    }
}