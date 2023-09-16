class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int order1 = 0;
        int order2 = 0;
        for (int i = 0; i < goal.length; i++) {
            for (int j = 0; j < cards1.length; j++) { // cards1 순서 확인
                if (goal[i].equals(cards1[j])) {
                    if (j != order1) answer = "No"; // 순서가 맞지 않으면 No
                    order1++;
                    break;
                }
            }
            for (int j = 0; j < cards2.length; j++) { // cards2 순서 확인
                if (goal[i].equals(cards2[j])) {
                    if (j != order2) answer = "No"; // 순서가 맞지 않으면 No
                    order2++;
                    break;
                }
            }
        }
        return answer;
    }
}