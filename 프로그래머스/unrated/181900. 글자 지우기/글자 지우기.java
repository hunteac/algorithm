class Solution {
    public String solution(String my_string, int[] indices) {
        String[] tmp = my_string.split("");
        String answer = "";
        for (int i = 0; i < indices.length; i++) {
            tmp[indices[i]] = ""; // indices의 원소에 해당하는 인덱스 지우기
        }
        for (int i = 0; i < tmp.length; i++) {
            if (!tmp[i].equals("")) answer += tmp[i]; // 인덱스 지운 문자열 구하기
        }
        return answer;
    }
}