class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        int idx = 0;
        int cnt = 0;
        String s = "";
        boolean flag = false;
        if (A.equals(B)) return 0;
        for (int i = 1; i < A.length(); i++) {
            s = "";
            idx = A.length() - i;
            cnt = 0;
            while (cnt < A.length()) { // 문자열 밀기
                s += A.charAt(idx++);
                if (idx == A.length()) idx = 0;
                cnt++;
            }
            answer++; // 민 횟수 + 1
            if (s.equals(B)) { // 민 문자열이 B와 동일하다면
                flag = true;
                break; // 반복문 탈출
            }
        }
        if (flag) return answer; 
        else return -1;
    }
}