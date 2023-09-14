import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        List<Character> list = new ArrayList<>(); // 포함여부를 확인하기 위한 리스트 생성
        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            if (!list.contains(s.charAt(i))) { // 해당 문자를 포함하고 있지 않다면 -1
                list.add(s.charAt(i));
                answer[i] = -1;
                continue;
            }
            list.add(s.charAt(i));
            while (true) { // 해당 문자를 포함하고 있다면 가장 가까운 위치 찾기
                cnt++;
                if (list.get(list.size() - cnt - 1) == s.charAt(i)) {
                    answer[i] = cnt;
                    break;
                }
            }
        }
        return answer;
    }
}