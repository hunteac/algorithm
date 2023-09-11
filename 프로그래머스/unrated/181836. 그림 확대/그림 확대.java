class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        String s = "";
        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < picture.length; i++) {
            while (cnt < picture[i].length()) {
                for (int j = 0; j < k; j++) { // 그림 파일 늘리기
                    s += picture[i].charAt(cnt);    
                }
                cnt++;     
            }    
            for (int j = 0; j < k; j++) {
                answer[idx++] = s; // 늘린 그림 파일 담기
            }
            cnt = 0;
            s = "";
        }
        return answer;
    }
}