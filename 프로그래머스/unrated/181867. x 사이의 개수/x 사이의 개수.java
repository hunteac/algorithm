class Solution {
    public int[] solution(String myString) {
        String[] sArr = myString.split("x"); // 문자열 x를 기준으로 나누기
        int len = 0; // 배열 길이 변수
        if (myString.charAt(myString.length() - 1) == 'x') len += sArr.length + 1; // 문자열이 x로 끝나는 경우 마지막 값은 0
        else len = sArr.length;
        int[] answer = new int[len];
        for (int i = 0; i < sArr.length; i++) {
            answer[i] = sArr[i].length(); // 각 문자열 길이 배열에 담기
        }
        return answer;
    }
}