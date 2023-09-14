import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        String[] tmp = new String[strings.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = strings[i].substring(n, n + 1); // 각 문자열의 인덱스 n번째를 기준으로
        }
        Arrays.sort(strings); // 사전 순으로 정렬
        Arrays.sort(tmp); // 사전 순으로 정렬
        for (int i = 0; i < tmp.length; i++) {
            String s = tmp[i];
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals(" ")) continue;
                if (s.equals(strings[j].substring(n, n + 1))) {
                    answer[i] = strings[j];
                    strings[j] = " ";
                    break;
                }
            }
        }
        return answer;
    }
}