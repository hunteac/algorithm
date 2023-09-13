class Solution {
    public String solution(String phone_number) {
        String answer = "";
        for (int i = 0; i < phone_number.length(); i++) {
            if (phone_number.length() - i <= 4) answer += phone_number.charAt(i); // 뒷 4자리만 숫자
            else answer += "*"; // 나머지 *
        }
        return answer;
    }
}