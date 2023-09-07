class Solution {
    public int[] solution(int[] arr) {
        int len = 0; // 배열 길이
        int cnt = 0; // 원소 추가 횟수
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            len += arr[i]; // 출력 배열 길이 구하기
        }
        int[] answer = new int[len];
        for (int i = 0; i < arr.length; i++) {
            while (cnt != arr[i]) { // arr[i] 만큼 원소 추가
                answer[idx++] = arr[i];
                cnt++;
            }
            cnt = 0;
        }
        return answer;
    }
}