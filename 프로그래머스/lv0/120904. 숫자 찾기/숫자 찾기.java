class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        String snum = String.valueOf(num);
        for (int i = 0; i < snum.length(); i++) {
            if (snum.charAt(i) - 48 == k) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}