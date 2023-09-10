class Solution {
    public int solution(int order) {
        int answer = 0;
        String sorder = String.valueOf(order);
        for (int i = 0; i < sorder.length(); i++) {
            if (sorder.charAt(i) == '3' || sorder.charAt(i) == '6' || sorder.charAt(i) == '9') answer++;
        }
        return answer;
    }
}