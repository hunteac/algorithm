class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        String num = "";
        while (n > 0) { 
            num += String.valueOf(n % 3); // 10진법 -> 3진법 후 뒤집기
            n /= 3;
        }
        for (int i = num.length() - 1; i >= 0; i--) {
            answer += (int) Math.pow(3, cnt++) * (num.charAt(i) - '0'); // 3진법 -> 10진법
        }
        return answer;
    }
}