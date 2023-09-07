class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) == alp.charAt(0)) answer += String.valueOf(my_string.charAt(i)).toUpperCase(); // alp와 동일한 소문자 대문자로 변환
            else answer += my_string.charAt(i);
        }
        return answer;
    }
}