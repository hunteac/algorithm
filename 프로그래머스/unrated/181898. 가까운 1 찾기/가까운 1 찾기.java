class Solution {
    public int solution(int[] arr, int idx) {
        int answer = -1; // 못찾을 경우를 대비해 값을 -1로 설정
        for (int i = 0; i < arr.length; i++) {
            if (i >= idx && arr[i] == 1) {
                answer = i; // idx보다 크면서 배열의 값이 1인 가장 작은 인덱스
                break;
            } 
        }
        return answer;
    }
}