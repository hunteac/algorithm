class Solution {
    public String[] solution(String[] strArr) {
        int cnt = 0;
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j <= strArr[i].length() - 2; j++) {
                if (strArr[i].substring(j, 2 + j).equals("ad")) { // ad를 포함하면 해당 문자열 지우기
                    strArr[i] = "";
                    cnt++;   
                } 
            }
        }
        String[] answer = new String[strArr.length - cnt]; // 출력 배열 선언
        cnt = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != "") answer[cnt++] = strArr[i]; // 남은 문자열 담기
        }
        return answer;
    }
}