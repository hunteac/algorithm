class Solution {
    public int[] solution(int n) {
        int[] tmp = new int[1000]; // 콜라츠 수열을 만들기 위한 임시 배열 선언
        int cnt = 0;
        while (n != 1) {
            tmp[cnt++] = n;
            if (n % 2 == 0) n /= 2;
            else n = n * 3 + 1;
        }
        tmp[cnt] = 1;
        cnt = 0;
        while (tmp[cnt] != 0) {
            cnt++;
        }
        int[] answer = new int[cnt]; // 콜라츠 수열
        cnt = 0;
        while (tmp[cnt] != 0) {
            answer[cnt] = tmp[cnt];
            cnt++;
        }
        return answer;
    }
}