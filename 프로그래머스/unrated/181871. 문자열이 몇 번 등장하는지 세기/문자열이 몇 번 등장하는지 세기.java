class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        for (int i = 0; i <= myString.length() - pat.length(); i++) {
            if (myString.substring(i, pat.length() + i).equals(pat)) answer++; // pat 등장횟수 구하기
        }
        return answer;
    }
}