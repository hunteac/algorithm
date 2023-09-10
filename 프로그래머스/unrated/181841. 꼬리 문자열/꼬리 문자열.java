class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        for (int i = 0; i < str_list.length; i++) {
            boolean flag = true;
            for (int j = 0; j <= str_list[i].length() - ex.length(); j++) {
                if (str_list[i].substring(j, ex.length() + j).equals(ex)) { // 특정 문자열 포함 여부 확인
                    flag = false;
                    break;
                }
            }
            if (flag) answer += str_list[i]; // 포함하지 않는다면 꼬리 문자열 합치기
        }
        return answer;
    }
}