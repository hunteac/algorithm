class Solution {
    public int solution(String my_string, String target) {
        boolean flag = false;
        for (int i = 0; i <= my_string.length() - target.length(); i++) {
            if (my_string.substring(i, target.length() + i).equals(target)) flag = true; // 부분 문자열 찾기
        }
        if (flag) return 1;
        else return 0;
    }
}