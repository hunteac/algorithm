class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            if (i % 2 == 0) answer[i] = strArr[i].toLowerCase(); // 짝수번째 인덱스 소문자로
            else answer[i] = strArr[i].toUpperCase(); // 홀수번째 인덱스 대문자로
        }
        return answer;
    }
}