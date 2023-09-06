class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = new int[(intervals[0][1] - intervals[0][0] + 1) + (intervals[1][1] - intervals[1][0] + 1)]; // 출력할 배열 선언
        int cnt = 0;
        for (int i = 0; i < 2; i++) { // 2개의 구간
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                answer[cnt++] = arr[j]; // 각 구간별 값 담기
            }
        }
        return answer;
    }
}