class Solution {
    public String[] solution(String my_string) {
        String[] tmp = my_string.split(" ");
        int cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (!tmp[i].equals("")) // 단어 개수 구하기
                cnt++;
        }
        String[] answer = new String[cnt]; // 단어 개수만큼 길이를 가지는 배열선언
        cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (!tmp[i].equals(""))
                answer[cnt++] = tmp[i]; // 공백이 아닌 값 입력
        }
        return answer;
    }
}