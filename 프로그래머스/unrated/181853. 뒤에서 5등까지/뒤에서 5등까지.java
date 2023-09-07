import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[5];
        Arrays.sort(num_list); // 오름차순 정렬
        for (int i = 0; i < 5; i++) {
            answer[i] = num_list[i]; // 가장 작은 5개 수 담기
        }
        return answer;
    }
}