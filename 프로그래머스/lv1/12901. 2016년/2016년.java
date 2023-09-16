class Solution {
    public String solution(int a, int b) {
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"}; // 요일
        int[] dayNums = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 월별 일 수
        int dayNum = 0; // 날짜
        for (int i = 0; i < a - 1; i++) {
            dayNum += dayNums[i];
        }
        return day[(dayNum + b) % 7]; // 1월 1일 금요일을 기준으로 계산
    }
}