class Solution {
    public int solution(String myString, String pat) {
        String tmp = "";
        boolean flag = false;
        for (int i = 0; i < myString.length(); i++) { // 문자열 바꾸기
            if (myString.charAt(i) == 'A') tmp += "B"; 
            else tmp += "A";
        }
        for (int i = 0; i <= tmp.length() - pat.length(); i++) {
            if (tmp.substring(i, pat.length() + i).equals(pat)) flag = true; // 부분 문자열 중 pat이 있다면 flag = true
        }
        if (flag) return 1; // 부분 문자열 중 pat이 있다면 1 반환
        else return 0; // 없으면 0 반환
    }
}