class Solution {
    public int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 50 && arr[i] % 2 == 0) arr[i] /= 2; // 값이 50보다 크거나 같은 짝수라면 2로 나눈다.
            else if (arr[i] < 50 && arr[i] % 2 == 1) arr[i] *= 2; // 값이 50보다 작은 홀수라면 2를 곱한다.
        }
        return arr;
    }
}