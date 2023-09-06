class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        int idx = 0;
        while (answer <= n) { // 합이 n보다 클때까지 반복
            answer += numbers[idx++];
        }
        return answer;
    }
}