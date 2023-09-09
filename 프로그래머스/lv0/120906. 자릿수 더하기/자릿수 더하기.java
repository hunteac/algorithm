class Solution {
    public int solution(int n) {
        String s = String.valueOf(n);
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer += s.charAt(i) - 48; // 각 자리 숫자 합
        }
        return answer;
    }
}