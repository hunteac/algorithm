class Solution {
    public int[] solution(int[] arr, int k) {
        boolean flag = false;
        if (k % 2 == 0) flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (flag) arr[i] += k; // k가 짝수라면 모든 원소에 k 더하기
            else arr[i] *= k; // k가 홀수라면 모든 원소에 k 곱하기
        }
        return arr;
    }
}