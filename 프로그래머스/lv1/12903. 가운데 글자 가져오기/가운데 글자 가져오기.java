class Solution {
    public String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 1) answer += s.charAt(s.length() / 2); // 단어 길이 홀수
        else {
            answer += s.charAt(s.length() / 2 - 1); // 단어 길이 짝수
            answer += s.charAt(s.length() / 2);    
        } 
        return answer;
    }
}