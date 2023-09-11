class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        for (int i = 0; i < keyinput.length; i++) {
            if (keyinput[i].equals("up") && answer[1] < board[1] / 2) answer[1]++; // 범위를 벗어나지 않으면 위 한 칸 이동
            else if (keyinput[i].equals("down") && answer[1] > -(board[1] / 2)) answer[1]--; // 아래 한 칸 이동
            else if (keyinput[i].equals("left") && answer[0] > -(board[0] / 2)) answer[0]--; // 좌측 한 칸 이동
            else if (keyinput[i].equals("right") && answer[0] < board[0] / 2) answer[0]++; // 우측 한 칸 이동
        }
        return answer;
    }
}