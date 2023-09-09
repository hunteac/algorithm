class Solution {
    public String solution(String my_string) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            if (String.valueOf(my_string.charAt(i)).equals(String.valueOf(my_string.charAt(i)).toUpperCase())) // 대문자면
                answer += String.valueOf(my_string.charAt(i)).toLowerCase(); // 소문자로
            else // 소문자면
                answer += String.valueOf(my_string.charAt(i)).toUpperCase(); // 대문자로
        }
        return answer;
    }
}