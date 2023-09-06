class Solution {
    public int solution(String myString, String pat) {
        boolean flag = false;
        if (pat.length() > myString.length()) return 0;
        for (int i = 0; i <= myString.length() - pat.length(); i++) {
            if (myString.substring(i, pat.length() + i).equalsIgnoreCase(pat)) flag = true; // 대, 소문자 구분 X
        }
        if (flag) return 1; // 부분 문자열이면 1 반환
        else return 0; // 아니면 0 반환
    }
}