import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] food) {
        int len = 1;
        int idx = 0;
        for (int i = 1; i < food.length; i++) { // 음식 배치 길이 구하기
            len += (food[i] / 2) * 2;
        }
        String[] foods = new String[len]; // 음식 배치 배열
        foods[len / 2] = "0"; // 물은 가운데 배치
        for (int i = 1; i < food.length; i++) {
            if (food[i] == 1) continue; // 음식 1개는 배치할 수 없다.
            for (int j = 0; j < food[i] / 2; j++) { // 음식 배치하기
                foods[idx] = foods[foods.length - idx - 1] = String.valueOf(i);
                idx++;
            }
        }
        return Arrays.stream(foods).collect(Collectors.joining()); // 배열 -> 문자열 변환
    }
}