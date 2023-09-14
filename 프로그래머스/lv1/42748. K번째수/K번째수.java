import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] tmp = new int[commands[i][1] - commands[i][0] + 1]; // 임시 배열
            int idx = 0;
            for (int j = commands[i][0]; j <= commands[i][1]; j++) { // 배열 자르기
                tmp[idx++] = array[j - 1];    
            }
            Arrays.sort(tmp); // 오름차순 정렬
            answer[i] = tmp[commands[i][2] - 1]; // 자른 배열의 k번째 수 담기
        }
        return answer;
    }
}