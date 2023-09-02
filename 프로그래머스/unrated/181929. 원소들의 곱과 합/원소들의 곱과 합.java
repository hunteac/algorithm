class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int A = 1;
        int B = 0;
        for (int i = 0; i < num_list.length; i++) {
            A *= num_list[i];
            B += num_list[i];
        }
        if (A < B * B) answer = 1;
        return answer;
    }
}