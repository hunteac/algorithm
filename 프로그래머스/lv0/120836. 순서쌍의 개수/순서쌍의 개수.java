class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) { // 순서쌍의 개수 == 약수의 개수
            if (n % i == 0) answer++;
        }
        return answer;
    }
}