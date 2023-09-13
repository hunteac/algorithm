class Solution {
    public long solution(long price, int money, int count) {
        long answer = 0;
        for (int i = 1; i <= count; i++) {
            answer += price * i; // 전체 이용료
        }
        if (answer > money) return answer - money;
        else return 0;
    }
}