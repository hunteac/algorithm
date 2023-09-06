class Solution {
    public int solution(int[] arr) {
        int[] tmp = new int[arr.length];
        int answer = 0;
        int cnt = 0;
        while (true) {
            cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                tmp[i] = arr[i]; // 임시 배열에 기존 배열 값 담기
            }
            for (int i = 0; i < arr.length; i++) { // 배열 작업 수행
                if (arr[i] >= 50 && arr[i] % 2 == 0) arr[i] /= 2;
                else if (arr[i] < 50 && arr[i] % 2 == 1) arr[i] = arr[i] * 2 + 1;
            }
            for (int i = 0; i < arr.length; i++) { // 두 배열 원소 비교
                if (tmp[i] == arr[i]) {
                    cnt++;
                }   
            }
            if (cnt == arr.length) break; // arr[x] = arr[x + 1]이라면 반복문 탈출
            answer++;
        }
        return answer;
    }
}