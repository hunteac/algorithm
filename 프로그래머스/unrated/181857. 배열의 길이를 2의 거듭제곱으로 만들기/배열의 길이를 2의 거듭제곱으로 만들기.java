class Solution {
    public int[] solution(int[] arr) {
        int n = 1;
        while (n < arr.length) { // arr 길이보다 큰 2의 정수 거듭제곱 중 가장 작은 수 구하기
            n *= 2;
        }
        int[] answer = new int[n];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }
        return answer;
    }
}