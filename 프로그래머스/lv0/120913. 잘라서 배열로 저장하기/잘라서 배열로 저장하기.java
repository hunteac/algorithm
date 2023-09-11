class Solution {
    public String[] solution(String my_str, int n) {
        int len = 0;
        if (my_str.length() % n != 0) len = my_str.length() / n + 1;
        else len = my_str.length() / n;
        String[] answer = new String[len];
        int idx = 0;
        for (int i = 0; i < my_str.length(); i += n) { // 문자열 자르기
            if (i + n >= my_str.length()) answer[idx] = my_str.substring(i, my_str.length());
            else answer[idx++] = my_str.substring(i, i + n);
        }
        return answer;
    }
}