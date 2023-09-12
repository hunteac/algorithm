class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] chk = new int[201]; // 두 개 이상 겹치는 선분들의 길이 중복 계산 X
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (lines[i][0] <= lines[j][0] && lines[i][1] >= lines[j][1]) {
                    for (int k = lines[j][0]; k < lines[j][1]; k++) {
                        chk[100 - k]++;
                    }
                } else if (lines[j][0] <= lines[i][0] && lines[j][1] >= lines[i][1]) {
                    for (int k = lines[i][0]; k < lines[i][1]; k++) {
                        chk[100 - k]++;
                    }
                } else if (lines[i][1] >= lines[j][1]) {
                    if (lines[j][1] < lines[i][0]) continue;
                    for (int k = lines[i][0]; k < lines[j][1]; k++) {
                        chk[100 - k]++;
                    }
                 } else if (lines[j][1] > lines[i][1]) {
                    if (lines[j][0] > lines[i][1]) continue;
                    for (int k = lines[j][0]; k < lines[i][1]; k++) {
                        chk[100 - k]++;
                    }
                }    
            }
        }
        for (int i = 0; i < chk.length; i++) {
            if (chk[i] > 0) answer++;
        }
        return answer;
    }
}