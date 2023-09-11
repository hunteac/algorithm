class Solution {
    public int solution(int n) {
        int answer = 0;
        int len = 0;
        int cnt = 1;
        while (cnt <= n) {
            answer++;
            if (answer % 3 == 0) answer++; // 3의 배수 건너뛰기
            String s = String.valueOf(answer);
            while (true) {
                len = 0;
                for (int i = 0; i < s.length(); i++) { // 숫자 3 사용여부 파악
                    if (s.charAt(i) == '3') len++;
                }
                if (len > 0) answer++;
                else break;
                s = String.valueOf(answer);
            }
            if (answer % 3 == 0) answer++; // 3의 배수 건너뛰기
            cnt++;
            System.out.println(answer);
        }
        return answer;
    }
}