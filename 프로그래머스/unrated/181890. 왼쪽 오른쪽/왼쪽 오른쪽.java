class Solution {
    public String[] solution(String[] str_list) {
        String[] tmp = new String[20]; // 임시 배열 선언
        int cnt = 0;
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) { // 먼저 문자열 l이 나오면
                int idx = i;
                for (int j = idx - 1; j >= 0; j--) { // l 기준 왼쪽에 있는 문자열 담기
                    tmp[j] = str_list[j];
                    cnt++;
                }
                break;
            } else if (str_list[i].equals("r")) { // 먼저 문자열 r이 나오면
                int idx = i;
                for (int j = idx + 1; j < str_list.length; j++) { // r 기준 오른쪽에 있는 문자열 담기
                    tmp[j] = str_list[j];
                    cnt++;
                }
                break;
            }
        }
        String[] answer = new String[cnt]; // 출력 배열 선언
        cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != null) // NULL이 아닌 경우만
                answer[cnt++] = tmp[i]; // 문자열 담기
        }
        return answer;
    }
}