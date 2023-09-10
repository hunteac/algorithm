class Solution {
    public String solution(String myString) {
        String answer = "";
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) < 109) answer += "l"; // l 이전 문자 l로 변환
            else answer += myString.charAt(i);
        }
        return answer;
    }
}