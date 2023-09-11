class Solution {
    public int solution(int chicken) {
        int answer = 0; // 서비스 치킨 수
        int coupon = 0; // 쿠폰 수
        int left = 0;
        while (chicken >= 10) {
            coupon += chicken % 10;
            chicken /= 10;
            answer += chicken; // 서비스 치킨 수 더하기
        }
        coupon += chicken;
        while (coupon >= 10) { // 남은 쿠폰 사용
            left = coupon / 10;
            answer += left;
            coupon %= 10;
            coupon += left;
        }
        return answer;
    }
}