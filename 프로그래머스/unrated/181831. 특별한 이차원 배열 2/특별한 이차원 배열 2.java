class Solution {
    public int solution(int[][] arr) {
        boolean flag = true;
        Outer: for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != arr[j][i]) { // 동일하지 않으면 false, 반복문 탈출
                    flag = false;
                    break Outer;
                }
            }
        }
        if (flag) return 1; // 동일하면 1 반환
        else return 0;
    }
}