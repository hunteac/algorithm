import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] tmparr = new int[numlist.length];
        int[] answer = new int[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            tmparr[i] = Math.abs(numlist[i] - n); // 거리를 구하기 위한 절댓값 메소드 사용
        }
        Arrays.sort(numlist);
        Arrays.sort(tmparr);
        for (int i = 0; i < tmparr.length; i++) {
            for (int j = numlist.length - 1; j >= 0; j--) {
                if (tmparr[i] == Math.abs(numlist[j] - n)) { // 절댓값이 같으면 큰 수부터 나열
                    answer[i] = numlist[j];
                    numlist[j] = 10000 + n;
                    break;
                }
            }
        }
        return answer;
    }
}