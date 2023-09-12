class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            int sum = 0;
            String[] arr = quiz[i].split(" ");
            if (arr[1].equals("+")) sum += (Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]));
            else sum += (Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]));
            if (sum == Integer.parseInt(arr[4])) answer[i] = "O";
            else answer[i] = "X";
        }
        return answer;
    }
}