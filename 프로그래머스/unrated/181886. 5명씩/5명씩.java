class Solution {
    public String[] solution(String[] names) {
        String[] answer = new String[(names.length - 1) / 5 + 1];
        int cnt = 0;
        for (int i = 0; i < names.length; i += 5) { // 5명씩 묶은 그룹의 가장 앞에 있는 사람
            answer[cnt++] = names[i];
        }
        return answer;
    }
}