class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for (int i = 3; i <= sum / 3; i++) { // 세로길이는 최소 3
            if (sum % i == 0) {
                int r = i; // 세로
                int c = sum / i; // 가로
 
                if (c * 2 + (r - 2) * 2 == brown) {   
                    answer[0] = c;
                    answer[1] = r;
                    break; 
                }
            }
        }
        
        return answer;
    }
}