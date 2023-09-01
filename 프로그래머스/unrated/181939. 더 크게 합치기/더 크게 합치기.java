class Solution {
    public int solution(int a, int b) {
        String[] sarr = new String[2];
        sarr[0] = String.valueOf(a);
        sarr[1] = String.valueOf(b);
        int tmpA = Integer.parseInt(sarr[0] + sarr[1]);
        int tmpB = Integer.parseInt(sarr[1] + sarr[0]);
        int answer = Math.max(tmpA, tmpB);
        return answer;
    }
}