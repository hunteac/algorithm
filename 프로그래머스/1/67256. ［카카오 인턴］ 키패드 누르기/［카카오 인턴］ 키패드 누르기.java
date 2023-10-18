import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[] right = new int[] {3, 2}; // 오른손 엄지 위치
        int[] left = new int[] {3, 0}; // 왼손 엄지 위치
        
        int[][] keypad = new int[10][2];
        keypad[0][0] = 3;
        keypad[0][1] = 1;
        
        int idx = 1;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keypad[idx][0] = i;
                keypad[idx][1] = j;
                idx++;
            }
        }
        
        for (int i = 0; i < numbers.length; i++) { // 1, 4, 7: 왼손
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                left[0] = keypad[numbers[i]][0]; // 왼손 위치 옮기기
                left[1] = keypad[numbers[i]][1];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) { // 3, 6, 9: 오른손
                answer += "R";
                right[0] = keypad[numbers[i]][0]; // 오른손 위치 옮기기
                right[1] = keypad[numbers[i]][1];
            } else { // 2, 5, 8, 0: 거리 측정
                int num = numbers[i];
                // 오른손 거리
                int rdist = Math.abs(keypad[num][0] - right[0]) + Math.abs(keypad[num][1] - right[1]);
                // 왼손 거리
                int ldist = Math.abs(keypad[num][0] - left[0]) + Math.abs(keypad[num][1] - left[1]);
                
                if (ldist > rdist) { // 왼손이 더 먼 경우
                    answer += "R";
                    right[0] = keypad[num][0];
                    right[1] = keypad[num][1];
                } else if (rdist > ldist) { // 오른손이 더 먼 경우
                    answer += "L";   
                    left[0] = keypad[num][0];
                    left[1] = keypad[num][1];
                } else { // 거리가 같은 경우
                    if (hand.equals("right")) { // 오른손잡이
                        answer += "R";
                        right[0] = keypad[num][0];
                        right[1] = keypad[num][1];
                    } else { // 왼손잡이
                        answer += "L";   
                        left[0] = keypad[num][0];
                        left[1] = keypad[num][1];
                    }
                } 
            }   
        }
            
        return answer;
    }
}