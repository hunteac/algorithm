class Solution {
    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            maxX = Math.max(maxX, sizes[i][0]); // 모든 명함을 담을 수 있는 가로 길이
            maxY = Math.max(maxY, sizes[i][1]); // 모든 명함을 담을 수 있는 세로 길이
        }
        return maxX * maxY; // 지갑 크기 반환
    }
}