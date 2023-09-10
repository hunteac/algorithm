class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for (int i = 0; i < order.length; i++) {
            if (order[i].substring(3, order[i].length()).equals("cafelatte") || order[i].substring(0, order[i].length() - 3).equals("cafelatte") || order[i].equals("cafelatte")) answer += 5000; // 카페라떼 5000원
            else answer += 4500; // 아메리카노, 아무거나 4500원
        }
        return answer;
    }
}