class Solution {
    public int[] solution(int start, int end_num) {
        int[] answer = new int[start - end_num + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = start--; // start_num 부터 1씩 감소하는 수 담기
        }
        return answer;
    }
}