class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        int idx = 0;
        for (int i = 0; i <= myString.length() - pat.length(); i++) {
            if (myString.substring(i, pat.length() + i).equals(pat)) idx = i; // pat과 동일한 최대 인덱스 구하기
        }
        for (int i = 0; i < idx + pat.length(); i++) {
            answer += myString.charAt(i); // 가장 긴 부분 문자열 담기
        }
        return answer;
    }
}