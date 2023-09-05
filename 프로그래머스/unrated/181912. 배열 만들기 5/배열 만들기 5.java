class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] tmp = new int[intStrs.length]; // 임시 배열 선언
        int len = 0;
        for (int i = 0; i < intStrs.length; i++) {
            int n = Integer.parseInt(intStrs[i].substring(s, s + l)); // s번 인덱스에서 길이 l까지 잘라내기
            if (n > k) { // 변환한 정수값이 k보다 크면
                tmp[i] = n;
                len++;
            }
        }
        int[] answer = new int[len]; // 출력할 배열 선언
        len = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != 0) answer[len++] = tmp[i];
        }
        return answer;
    }
}