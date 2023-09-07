class Solution {
    public String solution(String rny_string) {
        String answer = "";
        for (int i = 0; i < rny_string.length(); i++) {
            if (rny_string.charAt(i) == 'm') answer += "rn"; // 모든 'm'을 'rn'으로 변환
            else answer += rny_string.charAt(i);
        }
        return answer;
    }
}