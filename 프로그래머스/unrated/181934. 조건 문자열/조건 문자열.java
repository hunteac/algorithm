class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        String s1 = ineq;
        String s2 = eq;
        if (s1.equals(">") && s2.equals("=")) {
            if (n >= m) answer = 1;
        } else if (s1.equals(">") && s2.equals("!")) {
            if (n > m) answer = 1;
        } else if (s1.equals("<") && s2.equals("=")) {
            if (n <= m) answer = 1;
        } else if (s1.equals("<") && s2.equals("!")) {
            if (n < m) answer = 1;
        }
        return answer;
    }
}