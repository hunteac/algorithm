class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52]; // 정수 배열 선언
        for (int i = 0; i < my_string.length(); i++) {
            int n = my_string.charAt(i); // ASCII 코드 활용하여 개수 구하기
            if (n > 96) answer[n - 71]++; // 알파벳 소문자
            else answer[n - 65]++; // 알파벳 대문자
        }
        return answer;
    }
}