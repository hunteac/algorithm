import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length - 5]; // 가장 작은 5개를 제외한 수 입력을 위한 길이 설정
        int idx = 0;
        Arrays.sort(num_list); // 오름차순 정렬
        for (int i = 5; i < num_list.length; i++) {
            answer[idx++] = num_list[i];
        }
        return answer;
    }
}