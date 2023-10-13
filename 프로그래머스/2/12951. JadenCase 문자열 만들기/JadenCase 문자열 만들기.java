class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') { // 공백 추가
                answer += " ";
                idx = 0;
                continue;
            }
            
            if (idx == 0 && !Character.isDigit(c)) { // 대문자 변환
                answer += String.valueOf(c).toUpperCase();
                idx++;
            } else if (idx == 0 && Character.isDigit(c)) { // 숫자
                answer += c;
                idx++;
            } else answer += String.valueOf(c).toLowerCase(); // 소문자 변환
        }
        
        return answer;
    }
}