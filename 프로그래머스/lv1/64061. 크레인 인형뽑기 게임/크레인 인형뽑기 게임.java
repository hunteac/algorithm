import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int c = moves[i];
            for (int j = 0; j < board.length; j++) { // 인형 뽑기
                if (board[j][c - 1] != 0) {
                    if (basket.isEmpty()) basket.push(board[j][c - 1]);
                    else {
                        if (basket.peek() == board[j][c - 1]) { // 같은 모양 인형 터트리기
                            basket.pop();
                            answer += 2;
                        } else {
                            basket.push(board[j][c - 1]);    
                        }
                    } 
                    board[j][c - 1] = 0; // 뽑은 인형 자리 초기화
                    break;
                } 
            }
        }
        return answer;
    }
}