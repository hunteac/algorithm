class Solution {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        int idx = answer.length - 1;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = String.valueOf(n).charAt(idx--) - '0';
        }
        return answer;
    }
}