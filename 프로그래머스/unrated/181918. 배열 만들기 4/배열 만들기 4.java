import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>(); // 임시 리스트 생성
        int tmpi = 0; // 임시 변수 tmpi 선언 및 초기화
        while (tmpi < arr.length) {
            if (list.isEmpty()) { // 빈 리스트면 arr[i]를 list에 추가, i 증가
                list.add(arr[tmpi]);
                tmpi++;
            } else if (list.get(list.size() - 1) < arr[tmpi]) { // 리스트 마지막 원소가 arr[i] 보다 작은 경우
                list.add(arr[tmpi]);    
                tmpi++;
            } else if (list.get(list.size() - 1) >= arr[tmpi]) { // 리스트 마지막 원소가 arr[i] 보다 크거나 같은 경우
                list.remove(list.size() - 1);
            }
        }
        int[] stk = new int[list.size()]; // stk 배열 선언
        for (int i = 0; i < stk.length; i++) {
            stk[i] = list.get(i);
        }
        return stk;
    }
}