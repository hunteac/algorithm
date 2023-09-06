class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) { // s <= i <= e인 모든 i의 arr[i]에 1씩 더하기
                arr[j]++;
            }
        }
        return arr;
    }
}