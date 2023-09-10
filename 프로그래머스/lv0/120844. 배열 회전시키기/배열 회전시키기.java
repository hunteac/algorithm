class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        boolean flag = false; // left = false
        if (direction.equals("right")) flag = true; // right = true
        if (flag) { // right면
            answer[0] = numbers[numbers.length - 1];
            for (int i = 1; i < answer.length; i++) {
                answer[i] = numbers[i - 1];
            }
        } else { // left면
            answer[answer.length - 1] = numbers[0];
            for (int i = 0; i < answer.length - 1; i++) {
                answer[i] = numbers[i + 1];
            }
        }
        return answer;
    }
}