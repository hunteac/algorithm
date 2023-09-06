class Solution {
    public int solution(int[] num_list) {
        int answer = 0; // 횟수 구하는 변수
        for (int i = 0; i < num_list.length; i++) {
            while (num_list[i] != 1) {
                if (num_list[i] % 2 == 0) num_list[i] /= 2; // 짝수라면 반으로 나눈다.
                else num_list[i] = (num_list[i] - 1) / 2; // 홀수라면 1을 뺀 뒤 반으로 나눈다.
                answer++; 
            }
        }
        return answer;
    }
}