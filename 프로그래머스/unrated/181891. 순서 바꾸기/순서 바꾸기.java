class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int cnt = 0;
        for (int i = n; i < num_list.length; i++) { // n번째 원소 이후의 원소들 담기
            answer[cnt++] = num_list[i];
        }
        for (int i = 0; i < n; i++) { // n번째까지의 원소들 담기
            answer[cnt++] = num_list[i];
        }
        return answer;
    }
}