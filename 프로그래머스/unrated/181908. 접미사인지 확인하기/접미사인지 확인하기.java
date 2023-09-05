class Solution {
    public int solution(String my_string, String is_suffix) {
        boolean chk = false; // 불린 변수 선언 및 초기화
        for (int i = 0; i < my_string.length(); i++) {
            String s = my_string.substring(i, my_string.length()); // 접미사 구하기
            if (s.equals(is_suffix)) chk = true; // 각 접미사와 비교하여 하나라도 동일하면 true
        }
        if (chk) return 1; // 접미사라면 1 출력
        else return 0; // 아니면 0 출력
    }
}