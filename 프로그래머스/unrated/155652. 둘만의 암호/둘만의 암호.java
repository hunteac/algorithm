import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] cArr = s.toCharArray(); // 문자열 -> 문자 배열 변환
        List<String> list = new ArrayList<>(Arrays.asList(skip.split("")));
        for (int i = 0; i < cArr.length; i++) {
            int idx = index;
            int cnt = 0;
            for (int j = 1; j <= idx; j++) {
                int tmp = cArr[i] + j; 
                if (tmp > 122 && tmp <= 148) tmp -= 26; // z를 넘어간 경우
                else if (tmp > 148) tmp -= 52; // 두번 이상 넘어간 경우
                if (list.contains(String.valueOf((char) tmp))) { // skip에 있는 알파벳은 제외
                    idx++;
                    cnt++;
                } 
            }
            int num = cArr[i] + index + cnt;
            if (num <= 122) 
                answer += (char) (cArr[i] + index + cnt);
            else if (num > 122 && num <= 148) // z를 넘어간 경우
                answer += (char) (cArr[i] + index + cnt - 26);
            else 
                answer += (char) (cArr[i] + index + cnt - 52);
        }
        return answer;
    }
}