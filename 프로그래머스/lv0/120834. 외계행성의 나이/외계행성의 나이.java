class Solution {
    public String solution(int age) {
        String answer = "";
        String sage = String.valueOf(age);
        for (int i = 0; i < sage.length(); i++) {
            answer += (char) (sage.charAt(i) + 49); // ASCII 코드 -> 문자 변환
        }
        return answer;
    }
}