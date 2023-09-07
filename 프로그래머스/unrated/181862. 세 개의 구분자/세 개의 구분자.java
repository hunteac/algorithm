class Solution {
    public String[] solution(String myStr) {
        String[] tmp = new String[myStr.length()];
        String tmps = "";
        int idx = 0; // 인덱스 변수
        int cnt = 0; // 문자열 개수 변수
        for (int i = 0; i < myStr.length(); i++) {
            tmps = "";
            while (i + idx < myStr.length() && myStr.charAt(i + idx) != 'a' && myStr.charAt(i + idx) != 'b' && myStr.charAt(i + idx) != 'c') { // 해당 문자가 a, b, c가 아닐때까지 문자 더하기
               tmps += myStr.charAt(i + idx++);
            }
            if (!tmps.equals(""))
                tmp[cnt++] = tmps; // 구한 문자열 배열에 담기
            i += idx; // idx만큼 반복문 건너뛰기
            idx = 0;
        }
        if (cnt == 0) cnt = 1; // a, b, c말고 문자가 없는 경우 "EMPTY"를 담기 위해 배열 크기 1로 선언
        String[] answer = new String[cnt];
        cnt = 0;
        for (String s : tmp) {
            if (s != null) answer[cnt++] = s;
        }
        if (cnt == 0) answer[0] = "EMPTY"; // a, b, c말고 문자가 없는 경우 "EMPTY" 담기
        return answer;
    }
}