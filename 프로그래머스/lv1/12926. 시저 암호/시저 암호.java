class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 91 && s.charAt(i) != ' ') {
                if (s.charAt(i) + n >= 91) answer += (char) (s.charAt(i) + n - 26); // 대문자 밀기
                else answer += (char) (s.charAt(i) + n);    
            } else if (s.charAt(i) > 91 && s.charAt(i) != ' ') {
                if (s.charAt(i) + n >= 123) answer += (char) (s.charAt(i) + n - 26); // 소문자 밀기
                else answer += (char) (s.charAt(i) + n);    
            }
            if (s.charAt(i) == ' ') answer += " "; // 공백 추가
        }
        return answer;
    }
}