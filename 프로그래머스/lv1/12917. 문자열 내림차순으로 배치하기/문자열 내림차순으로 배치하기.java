import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        Arrays.sort(arr); // 오름차순 정렬
        StringBuffer sb = new StringBuffer(Arrays.stream(arr).collect(Collectors.joining())); // 정렬한 배열 문자열로 변환
        return sb.reverse().toString(); // 문자열 뒤집기
    }
}