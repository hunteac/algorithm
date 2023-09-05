class Solution {
    public String solution(String my_string, int s, int e) {
        String[] sarr = my_string.split(""); // 문자열의 각 문자 배열에 담기
        String answer = "";
        int left = s; // 왼쪽 문자
        int right = e; // 오른쪽 문자
        while (left < right) { // 문자열 뒤집기
            String tmp = sarr[left];
            sarr[left++] = sarr[right];
            sarr[right--] = tmp;
        }
        for (int i = 0; i < sarr.length; i++) {
            answer += sarr[i];
        }
        return answer;
    }
}