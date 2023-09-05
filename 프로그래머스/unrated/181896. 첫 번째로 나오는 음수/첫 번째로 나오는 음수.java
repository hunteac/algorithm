class Solution {
    public int solution(int[] num_list) {
        int answer = -1; // 음수가 없을 경우
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 0) {
                answer = i; // 음수를 찾으면 해당 인덱스로 바꾸고 반복문 탈출 
                break;
            }
        }
        return answer;
    }
}