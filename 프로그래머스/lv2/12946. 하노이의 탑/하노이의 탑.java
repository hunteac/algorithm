class Solution {
    public static int[][] answer;
    public static int l;
    
    public static void hanoi(int N, int from, int to, int tmp) {
        if (N == 0) return;
        
        hanoi(N - 1, from, tmp, to);
        answer[l][0] = from;
        answer[l++][1] = to;
        hanoi(N - 1, tmp, to, from);
    }
    public int[][] solution(int n) {
        l = 0;
        answer = new int[(1 << n) - 1][2];
        hanoi(n, 1, 3, 2);
        return answer;
    }
}