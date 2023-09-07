class Solution {
    public String solution(String myString) {
        String answer = "";
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'a' || myString.charAt(i) == 'A') answer += 'A';
            else if (myString.charAt(i) == ' ') answer += ' '; // 공백 추가
            else answer += String.valueOf(myString.charAt(i)).toLowerCase(); // 'A'가 아닌 모든 대문자 알파벳 소문자로 변환
        }
        return answer;
    }
}