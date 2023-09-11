import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        String[] arr = my_string.split("");
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].toLowerCase(); // 소문자로 변환
        }
        Arrays.sort(arr); // 사전순 정렬
        return Arrays.stream(arr).collect(Collectors.joining()); // 문자열 배열 -> 문자열 변환
    }
}