class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String s = "";
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) >= 48 && my_string.charAt(i) <= 57) {
                s = "";
                while (i < my_string.length() && my_string.charAt(i) >= 48 && my_string.charAt(i) <= 57) { // 연속된 숫자 구하기
                    s += my_string.charAt(i++);
                }
                answer += Integer.parseInt(s);
            }
        }
        return answer;
    }
}