class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i += m) {
            String s = my_string.substring(i, i + m); // m 글자씩 가로로 적기
            answer += s.charAt(c - 1); // 왼쪽부터 세로로 c 번째 열에 적힌 글자 더하기
        }
        return answer;
    }
}