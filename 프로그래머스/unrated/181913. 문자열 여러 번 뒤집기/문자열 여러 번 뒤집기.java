class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] carr = new char[my_string.length()];
        for (int i = 0; i < carr.length; i++) {
            carr[i] = my_string.charAt(i); // 각각의 문자를 문자 배열에 넣기
        }
        int l = 0; // start
        int r = 0; // end
        for (int i = 0; i < queries.length; i++) {
            l = queries[i][0]; // start
            r = queries[i][1]; // end
            while (l < r) {
                char c = carr[l];
                carr[l++] = carr[r];
                carr[r--] = c;
            }
        }
        String answer = "";
        for (int i = 0; i < carr.length; i++) {
            answer += String.valueOf(carr[i]); // 다 뒤집은 문자 문자열로 변환
        }
        return answer;
    }
}