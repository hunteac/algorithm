class Solution {
    public int[] solution(int[] arr) {
        int[] tmp = new int[100000];
        int min = 100000; // 최소 인덱스
        int max = -1; // 최대 인덱스
        int cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) tmp[i] = i;
            if (tmp[i] != -1) {
                min = Math.min(min, tmp[i]); // 값이 2인 최소 인덱스 구하기
                max = Math.max(max, tmp[i]); // 값이 2인 최대 인덱스 구하기
            }
        }
        if (min == 100000) { // arr에 2가 존재하지 않을 경우 출력 배열 크기는 1
            min = -1;
            max = -1;
        }
        int[] answer = new int[max - min + 1];
        if (min == -1) { // arr에 2가 존재하지 않으면 -1 담기
            answer[cnt] = -1;
        } else {
            for (int i = min; i <= max; i++) {
                answer[cnt++] = arr[i];
            }
        }
        return answer;
    }
}