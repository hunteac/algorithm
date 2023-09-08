class Solution {
    public int solution(String num_str) {
        int answer = 0;
        for (int i = 0; i < num_str.length(); i++) {
            answer += (int) num_str.charAt(i) - 48; // 정수로 형변환 후 더하기
        }
        return answer;
    }
}