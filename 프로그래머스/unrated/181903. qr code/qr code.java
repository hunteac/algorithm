class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        for (int i = 0; i < code.length(); i++) {
            // 각 인덱스를 q로 나누었을 때 나머지가 r인 위치의 문자를 더하기
            if (i % q == r) answer += code.charAt(i);
        }
        return answer;
    }
}