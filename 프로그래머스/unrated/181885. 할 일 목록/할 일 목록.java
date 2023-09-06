class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int len = 0; // 출력 배열 길이 구하기
        int idx = 0;
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) len++; // false인 일 수 구하기
        }
        String[] answer = new String[len];
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) answer[idx++] = todo_list[i];
        }
        return answer;
    }
}