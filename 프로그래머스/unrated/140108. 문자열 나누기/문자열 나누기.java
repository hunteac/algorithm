class Solution {
    public int solution(String s) {
        int[] count = new int[2];
        int answer = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(idx);
            
            if (s.charAt(i) == word) count[0]++; // x 글자 등장 횟수
            else count[1]++; // x가 아닌 글자 등장 횟수
            
            if (count[0] == count[1]) { // 등장 횟수가 같은 순간 분리하기
                answer++;
                idx += count[0] + count[1];
                count[0] = count[1] = 0; // 등장 횟수 초기화
            } else if (i == s.length() - 1) // 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없을 때
                answer++;
        }
        return answer;
    }
}