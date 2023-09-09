import java.util.ArrayList;
import java.util.List;

class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String s = "";
        String tmp = "";
        String[] arr = {"zero", "0", "one", "1", "two", "2", "three", "3", "four", "4", "five", "5", "six", "6", "seven", "7", "eight", "8", "nine", "9"}; // 0 ~ 9 문자열 배열
        String[] number = numbers.split("");
        for (int i = 0; i < number.length; i++) {
            s += number[i];
            for (int j = 0; j < arr.length; j += 2) {
                if (!s.equals(arr[j])) continue; // 문자열 배열에 존재하는 원소가 동일하다면
                tmp += arr[j + 1]; // 해당 원소 더하기
                s = ""; // 문자열 비우기
            }
        }
        answer = Long.parseLong(tmp); // Long형 정수로 변환
        return answer;
    }
}