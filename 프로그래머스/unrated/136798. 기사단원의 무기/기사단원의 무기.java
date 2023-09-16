class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0; // 철 무게
        int cnt = 0; // 약수 개수
        for (int i = 1; i <= number; i++) {
            cnt = 0;
            for (int j = 1; j * j <= i; j++) { // 약수 개수 구하기
                if (j * j == i) cnt++;
                else if (i % j == 0) cnt += 2;
            }
            if (cnt > limit) answer += power; // 제한수치를 초과하면 + power
            else answer += cnt;
        }
        return answer;
    }
}