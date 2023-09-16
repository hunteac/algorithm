class Solution {
    public int solution(int a, int b, int n) {
        int coke = 0; // 콜라병 수
        int empty = 0; // 남은 빈 병 수
        while (n >= a) { // 콜라 바꾸기
            coke += (n / a) * b;
            empty = n % a;
            n = (n / a) * b + empty;
        }
        return coke;
    }
}