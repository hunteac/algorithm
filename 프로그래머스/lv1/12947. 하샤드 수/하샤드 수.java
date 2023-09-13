class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int num = 0;
        for (int i = 0; i < String.valueOf(x).length(); i++) { // 자릿수 합 구하기
            num += String.valueOf(x).charAt(i) - '0';
        }
        if (x % num == 0) answer = true; // 나누어 떨어지면 true
        return answer;
    }
}