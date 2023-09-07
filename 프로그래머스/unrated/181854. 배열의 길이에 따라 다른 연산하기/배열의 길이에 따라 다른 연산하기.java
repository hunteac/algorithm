class Solution {
    public int[] solution(int[] arr, int n) {
        boolean flag = false;
        if (arr.length % 2 == 0) flag = true;
        if (flag) { // arr 길이가 짝수라면 
            for (int i = 1; i < arr.length; i += 2) { // 모든 홀수 인덱스에 n 더하기
                arr[i] += n;
            }
        } else { // arr 길이가 홀수라면
            for (int i = 0; i < arr.length; i += 2) { // 모든 짝수 인덱스에 n 더하기
                arr[i] += n;
            }
        }
        return arr;
    }
}