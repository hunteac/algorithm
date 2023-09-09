class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;        
        for (int tmpi = i; tmpi <= j; tmpi++) {
            String s = String.valueOf(tmpi);
            for (int tmpj = 0; tmpj < s.length(); tmpj++) {
                if (s.charAt(tmpj) - 48 == k) answer++; // k등장 횟수
            }
        }
        return answer;
    }
}