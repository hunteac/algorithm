class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            String tmps = String.valueOf(s.charAt(i));
            if (tmps.equals(" ")) {
                answer += " "; // 공백 추가
                idx = 0; // 인덱스 초기화
                continue;
            } else if (idx % 2 == 0) answer += tmps.toUpperCase(); // 짝수번째 알파벳은 대문자
            else answer += tmps.toLowerCase(); // 홀수번째 알파벳은 소문자
            idx++;
        }
        return answer;
    }
}