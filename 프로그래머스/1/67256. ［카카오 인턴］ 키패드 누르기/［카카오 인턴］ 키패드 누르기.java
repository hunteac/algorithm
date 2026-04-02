class Solution {
    class Pos {
        int row;
        int col;
        
        Pos (int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        public String getHand(String hand) {
            String result = "left".equals(hand) ? "L" : "R";
            
            int leftDist = getDist(left);
            int rightDist = getDist(right);
            
            System.out.println("leftDist: " + leftDist);
            System.out.println("rightDist: " + rightDist);
            
            if (leftDist < rightDist) {
                result = "L";
            } else if (rightDist < leftDist) {
                result = "R";
            }
            
            return result;
        }
        
        public int getDist(Pos pos) {
            return Math.abs(this.row - pos.row) + Math.abs(this.col - pos.col);
        }
    }
    
    Pos left;
    Pos right;
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // 1. 손 위치 초기화
        left = new Pos(3, 0);
        right = new Pos(3, 2);
        
        // 2. 숫자 조회
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            
            Pos numPos = new Pos((number - 1) / 3, (number - 1) % 3);
            if (number == 0) {
                numPos = new Pos(3, 1);
            }
            
            // 3. 손 선택 (col == 0 : 왼손, col == 2 : 오른손, col == 1 거리 계산)
            if (numPos.col == 0) {
                answer += "L";
            } else if (numPos.col == 2) {
                answer += "R";
            } else {
                answer += numPos.getHand(hand);
            }
            
            // 4. 손 위치 변경
            if ('L' == answer.charAt(i)) {
                left = new Pos(numPos.row, numPos.col);
            } else {
                right = new Pos(numPos.row, numPos.col);
            }
        }
        
        return answer;
    }
}