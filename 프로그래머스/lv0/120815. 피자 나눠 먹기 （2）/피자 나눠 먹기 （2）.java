class Solution {
    public int solution(int n) {
        if (n % 6 == 0) return n / 6; // 6의 배수
        else { // n이 6의 배수가 아니면
            int tmpn = n;
            while (n % 6 != 0) { // 6의 배수가 될때까지 n씩 더하고 배수가 된다면 / 6
                n += tmpn;
            }
            return n / 6;
        }
    }
}