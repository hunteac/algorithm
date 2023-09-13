class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            if (Long.parseLong(t.substring(i, p.length() + i)) <= Long.parseLong(p)) answer++; // 부분 문자열 중 작거나 같은 수 횟수 구하기
        }
        return answer;
    }
}