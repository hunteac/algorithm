import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 0; i < String.valueOf(n).length(); i++) {
            answer += String.valueOf(n).charAt(i) - '0';
        }
        return answer;
    }
}