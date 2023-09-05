class Solution {
    public int solution(String my_string, String is_prefix) {
        boolean chk = false; // 불린 변수 선언 및 초기화
        for (int i = 1; i < my_string.length(); i++) {
            String s = my_string.substring(0, i); // 접두사 구하기
            if (s.equals(is_prefix)) chk = true; // 각 접두사와 동일하다면 true
        }
        if (chk) return 1; // 접두사면 1 출력
        else return 0; // 아니면 0 출력
    }
}