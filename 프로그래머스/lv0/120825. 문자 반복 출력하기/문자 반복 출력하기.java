class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            for (int j = 0; j < n; j++) { // 각 문자 n만큼 반복
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }
}